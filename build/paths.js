var path = require('path');
var fs = require('fs');

var appRoot = 'src/';
var outputRoot = 'dist/';
var scssRoot = 'scss/';
var cssRoot = 'style/';
var exportSrvRoot = 'export/';
var pkg = JSON.parse(fs.readFileSync('./package.json', 'utf-8'));

module.exports = {
  root: appRoot,
  source: appRoot + '**/*.js',
  html: appRoot + '**/*.html',
  scss: scssRoot + '**/*.scss',
  output: outputRoot,
  cssOutput: cssRoot,
  exportSrv: exportSrvRoot,
  doc:'./doc',
  tests: 'test/unit/**/*.js',
  e2eSpecsSrc: 'test/e2e/src/**/*.js',
  e2eSpecsDist: 'test/e2e/dist/',
  packageName: pkg.name
};
