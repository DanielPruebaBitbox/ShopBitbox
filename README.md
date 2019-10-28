# Bitbox selection process assigment

_This project provides a CRUD for products in a shop_

### Technologies used 🚀

In order to develop this project the following technologies have been chosen:
* Java 8.0
* Angular 8
* Spring boot
* Hibernate
* H2


### Installation 🔧
##### Front End

In order to make this project work, you need to have installed Angular CLI and npm. The easiest way to do that in a Windows
 system is following this [guide]("https://www.freecodecamp.org/news/how-to-get-up-and-running-with-angular-on-windows-7405ba745c25/").

Once installed, go to _folderProjectSource/src/app/frontend/_ and run:


```
npm install 
```

With that all the dependencies will be installed, then use this command to run the front end in the port 8080:

```
ng serve
```

##### Backend

The backend is served in the port 4200 and there are two ways to get it running:
 * You could use any IDE (like IntelliJ or NetBeans) to install all the dependencies liste on the pom.xml file and then start the project from the IDE itself
 * You could manually start the project if you have Maven installed by going to the root of the project and running:
 ```mvn spring-boot:run```
 
 If you have any doubt on how to install Maven on your computer here is a [guide]("https://www.mkyong.com/maven/how-to-install-maven-in-windows/").
 
### Some Details ⚙️

Once the backend starts running, it will automatically generate some data (which can be checked in the "data.sql" document inside the project).
* You'll have an user to log in to the app. ``Credentials: user:user Password: password``
* You'll have two items already created: one active and another deactivated.

### Known issues 🔩

After the delivery of the project some minor issues have been found:
* Once you create an item it doesn't automatically set the creation date and the creator; it allows the user to set them to other values.
* Some models need to be refactored.
* Due to the lack of time the code lacks comments and tests.


### Last words ⌨️

Thank you for your time, and excuse me for adding the README file out of the delivery time; feel free to send me any suggestions via email: ``daniel.arbelo.cabrera@gmail.com``.
