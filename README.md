# Alphabet-Soup
Java project made for programming subject that consists of connecting to a database (in my case I have used MariaDB + XAMPP + MySQL, all of these mixed up should work) to save, delete and consult any word of your own. Then It generates an Alphabet Soup with those words and, if you want to see the result, there is a button for it.

## Prerequisites

You need a working environment with:

* [XAMPP](https://www.apachefriends.org/es/index.html) - You can install it from https://www.apachefriends.org/es/index.html.
* [MariaDB](https://mariadb.org) - You can install it from https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.7.3&os=windows&cpu=x86_64&pkg=msi&m=fe_up_pt.
Note: I am not really sure if you really need to install MariaDB. In any case, the java .jar are avaliable in this project so you don't need to install it.

## Java classes Explained

The primary objective of this project is to train the MVC schema in order to perform it on future project. 
This style of developing projects it is an interesting one because you make independent many things so that if you want to modify some parts of the code (like for example the querys) you only need to modify the Model class.

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/base_de_datos.PNG)

The view class contains all of the graphic part of the project and its like the main class where the model and the controller class will be implemented.
All of these will be implemented by methods of the buttons that performs the actions when clicked. For example, there is a button where it puts the word that you have written in the database using a method of the model class.

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/palabra.PNG)

The model class contains everything related to the connection of the database and the execution and implementation of the querys. In this case we are just only performing and Insert, Delete, and select query.

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/consultar.PNG)

In the image of above I have already put the word into the database.

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/eliminar.PNG)

Here I have deleted the word from before by just writing it in the text field and clicking the delete button.

Finally, the controller class contains the code that does not need neither the View nor the model class. What I am meaning with this is that if you execute this code alone in another project and put a main class where you invoke the alphabet soup methods you will get a functional alphabet soup in the console.

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/generacion_sopa_de_letras.PNG)

![Image text](https://github.com/JohanSantanaGalvanJob/Alphabet-Soup/blob/master/README_images/mostrar_resultado.PNG)
