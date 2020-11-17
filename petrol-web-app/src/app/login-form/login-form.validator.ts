import { AbstractControl, ValidationErrors } from '@angular/forms';

export class UsernameValidator  {

	static isDuplicateUserName(control: AbstractControl) : Promise<ValidationErrors | null> {

		return new Promise((resolve, reject) => {
			setTimeout(() => {
				
				if (control.value === 'deepak1') {
					resolve({ isDuplicateUserName: true })
				} else { 
					resolve(null) ;
				};
			}, 2000);
		});
	}
}