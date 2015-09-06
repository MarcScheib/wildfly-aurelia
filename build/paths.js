var path = require('path');

var appRoot = 'project/wildfly-aurelia-web/src/resources/assets/';
var outputRoot = 'project/wildfly-aurelia-web/src/main/webapp/assets/';

module.exports = {
  root: appRoot,
  source: appRoot + '**/*.js',
  html: appRoot + '**/*.html',
  style: appRoot + '**/*.scss',
  output: outputRoot,
  doc:'./doc',
  e2eSpecsSrc: 'test/e2e/src/*.js',
  e2eSpecsDist: 'test/e2e/dist/'
};
