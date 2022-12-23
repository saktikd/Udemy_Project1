Feature: Search and place order for products

Scenario: Search experience for product search in both home and offers page

Given User is on GreenCart Landing page
When use searched with product short name "Tom" and extracted actual name of product
Then user searched for "Tom" short name in offers page to check if product exist with same name
