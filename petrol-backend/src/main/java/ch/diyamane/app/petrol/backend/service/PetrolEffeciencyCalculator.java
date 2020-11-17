package ch.diyamane.app.petrol.backend.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
public class PetrolEffeciencyCalculator {

	HashMap<Date, Pumping> pumpingMap = new HashMap<Date, Pumping>();

	// Sorted the pumpList by date asc.
	public SortedMap<Date, Pumping> sortPumpingList() {
		return new TreeMap<Date, Pumping>(pumpingMap);
	}

	private void calculateMilage() {
		SortedMap<Date, Pumping> sortedMap = sortPumpingList();

		Date previousKey = null;
		for (Date key : sortedMap.keySet()) {

			Pumping currentPumping = sortedMap.get(key);

			if (sortedMap.firstKey() != key) {
				Pumping previousPumping = (Pumping) sortedMap.get(previousKey);
				previousPumping.calulateMilage(currentPumping);

				if (log.isDebugEnabled()) {
					log.debug("Previous Key : " + (Pumping) sortedMap.get(previousKey));
					log.debug("Current Key : " + currentPumping);
				}
			} else {
				if (log.isDebugEnabled())
					log.debug("First Key : " + (Pumping) sortedMap.get(key));
			}

			previousKey = key;
		}
	}

	public void addPumping(final Pumping pumping) {
		/*
		 * pumpingMap.put(pumping.getPumpDate(), pumping); calculateMilage();
		 */
	}

	public double calculateWeightedAverage(int month) {

		HashMap<Integer, ArrayList<Double>> monthMap = new HashMap<Integer, ArrayList<Double>>();

		for (Date key : sortPumpingList().keySet()) {
			DateTime dateTime = new DateTime(key.getTime());

			if (monthMap.containsKey(dateTime.getMonthOfYear())) {
				Pumping pump = sortPumpingList().get(key);
				monthMap.get(dateTime.getMonthOfYear()).add(pump.getMilage());
			} else {
				ArrayList<Double> milageList = new ArrayList<Double>();
				milageList.add(sortPumpingList().get(key).getMilage());

				monthMap.put(dateTime.getMonthOfYear(), milageList);
			}
		}

		for (Integer monthvalue : monthMap.keySet()) {

			double monthlyMilage = 0;
			for (Double milage : monthMap.get(monthvalue)) {
				monthlyMilage = monthlyMilage + milage;
			}

			if (log.isDebugEnabled())
				log.debug(
						"Monthly Avergae for month : " + month + " is " + monthlyMilage / monthMap.get(month).size());

			if (monthvalue == month) {

				return BigDecimal.valueOf(monthlyMilage / monthMap.get(month).size())
						.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue();

			}
		}

		return 0;

	}
}
