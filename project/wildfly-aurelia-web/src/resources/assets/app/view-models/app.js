import {WebAPI} from './../service/web-api';

export class App {
    static inject = [WebAPI];

    constructor(api) {
        this.api = api;
    }

    configureRouter(config, router) {
        config.title = 'Contacts';
        config.options.pushState = true;
        config.map([
            {route: '', moduleId: 'view-models/no-selection', title: 'Select'},
            {route: 'contacts/:id', moduleId: 'view-models/contact-detail', name: 'contacts'}
        ]);

        this.router = router;
    }
}
