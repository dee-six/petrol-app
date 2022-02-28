import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';


function log() {
	console.log("Petrol-web-app running in development mode !!!")
}

if (environment.production) {
  enableProdMode();
} else {
	log();
}


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
