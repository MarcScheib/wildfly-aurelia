# WildFly-Aurelia

Basic project architecture for JavaEE and [Aurelia][aurelia] on [WildFly][wildfly]. This example is based on the [Aurelia Contacts App][app-contacts].

## Running the project

To run the app, follow these steps.

1. Ensure that [NodeJS](http://nodejs.org/) is installed. This provides the platform on which the build tooling runs.
2. From the project folder, execute the following command:

  ```shell
  npm install
  ```
3. Ensure that [Gulp](http://gulpjs.com/) is installed. If you need to install it, use the following command:

  ```shell
  npm install -g gulp
  ```
4. Ensure that [jspm](http://jspm.io/) is installed. If you need to install it, use the following command:

  ```shell
  npm install -g jspm
  ```
  > **Note:** jspm queries GitHub to install semver packages, but GitHub has a rate limit on anonymous API requests. It is advised that you configure jspm with your GitHub credentials in order to avoid problems. You can do this by executing `jspm endpoint config github` and following the prompts.
5. Install the client-side dependencies with jspm:

  ```shell
  jspm install
  ```
  >**Note:** Windows users, if you experience an error of "unknown command unzip" you can solve this problem by doing `npm install -g unzip` and then re-running `jspm install`.
  
## WildFly Configuration

1. Ensure that WildFly is extracted somewhere on your drive.
2. Add the path to the WildFly directory to the JBOSS_HOME env variable.
3. Start the WildFly server.
4. Adjust the `config/src/main/resources/configuration.properties` to your needs and save it as `local.properties`.
5. On the cmd line, got to the config directory.
6. Run `mvn process-resources wildfly:execute-commands -P "config"`

[github]: https://github.com/MarcScheib/wildfly-aurelia
[aurelia]: http://aurelia.io/
[wildfly]: http://wildfly.org/
[app-contacts]: https://github.com/aurelia/app-contacts
