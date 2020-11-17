export class VehicleOwner {
    id;
    name;
    address1;
    address2;
    city;
    pinCode;
    country;
	subscriptionPaid;

	toString() {
		return 'VehicleOwner: {id=' + this.id + ', name=' + this.name + ', address1=' + this.address1 + ', address2=' 
		+ this.address2 + ', city=' + this.city + ', pinCode=' + this.pinCode +  ', country=' + this.country 
		+ ', subscriptionPaid=' + this.subscriptionPaid + '}';
	}
	
	isPaid() {
		return this.subscriptionPaid == "true";
	}
}