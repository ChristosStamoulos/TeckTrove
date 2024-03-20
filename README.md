# Application for a Personal Computer composition

## [***Software requirements in text format***](docs/markdown/software-requirements.md) in text format

The two stakeholders of our system, the direct users, are the customers and employers of the business.

The company's staff will have the possibility to modify the list of components, adding, removing and changing the characteristics of the products (price, name, etc.) as well as the offered required ports for their operation.

Customers will be able to search for individual products and formulations as well as learn related information about them. They will also be able to create their own PC compositions, save them for future purchase, publish them and evaluate the compositions of others. Finally, customers can add individual parts and assemblies to their shopping cart and complete the purchase by filling in the billing information on the relevant form.

In order for the composition storage process to be implemented, the system should store as well as retrieve the storage information for each personalized user. To implement the publication and evaluation of compositions, the system should store and update the list of components appropriately. Also, to make the purchase, the system should check if the composition meets the compatibility and completeness conditions. Otherwise it will prompt the user to modify their composition.

[***Assumptions made regarding the above requirements***](docs/markdown/english/software-requirements.md/#Assumptions-and-dependencies)

## ![Use Case Diagram](docs/markdown/uml/requirements/use-case-diagram.png)

## Convertion of Umlet diagrams
The conversion to an image of the Umlet diagrams placed in the docs/uml folder is done by executing the commands:
```bash
# linux
cd docs
./mvnw umlet:convert
```
```bash
# windows
cd docs
mvnw umlet:convert
```
A prerequisite is to initialize the JAVA_HOME environment variable with the location of the Java JDK.
