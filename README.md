Shopjfy - Caffeinated Shopify Bindings

The Shopjfy library allows Android developers to programatically access the Admin section of Shopify stores.

The API is implemented as JSON over HTTP using the CRest library.

# Usage #

For an example of how to make API calls, take a look at OrdersAPIEndpointTest.java

# MGAssetName.java #

These files were machine generated using the fixtures data from the test assets.  If you need to add additional
functionality to a model, you should make your changes to the subclass AssetName.java.

# Demo #

The included ShopifyProductsListDemo shows how to set up an application that will authorize against a users
Shopify store, calculate the API password for that store, fetch a list of products from a store and tell you
how many products it has.

The handshaking/OAuth-like aspect of the application was taken from [this tutorial](http://donpark.org/blog/2009/01/24/android-client-side-oauth).

# Known Issues #

* Trying to update information can lead to unexpected results.
* There are several dependencies which can lead to large applications.  It is in your best interest to
  get proguard working so you strip away any unused classes.