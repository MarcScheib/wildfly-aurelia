import {ConventionalViewStrategy, LogManager} from 'aurelia-framework';
import {ConsoleAppender} from 'aurelia-logging-console';

LogManager.addAppender(new ConsoleAppender());
LogManager.setLevel(LogManager.logLevel.debug);

ConventionalViewStrategy.convertModuleIdToViewUrl = function(moduleId) {
    var id = (moduleId.endsWith('.js')) ? moduleId.substring(0, moduleId.length - 3) : moduleId;
    return id.replace('view-models', 'views') + '.html';
};

export function configure(aurelia) {
    aurelia.use
        .defaultBindingLanguage()
        .defaultResources()
        .history()
        .router()
        .eventAggregator();

    aurelia.start().then(a => a.setRoot('view-models/app', document.body));
}

