import 'jquery';
import 'bootstrap';

export function configure(aurelia) {
  aurelia.use
    .standardConfiguration()
    .feature('resources');

  aurelia.use.developmentLogging();

  aurelia.start().then(() => aurelia.setRoot());
}
