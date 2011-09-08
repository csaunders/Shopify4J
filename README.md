Shopjfy - Caffeinated Shopify Bindings

The Shopjfy library allows Android developers to programatically access the Admin section of Shopify stores.

The API is implemented as JSON over HTTP using the CRest library.

# Usage #

For an example of how to make API calls, take a look at OrdersAPIEndpointTest.java

## MGAssetName.java ##

These files were machine generated using the fixtures data from the test assets.  If you need to add additional
functionality to a model, you should make your changes to the subclass AssetName.java.

## Shop password and App callback Uri ##

In order to make API calls, you will need to get the user to authorize your [application as shown in the documentation](http://api.shopify.com/authentication.html).
Thankfully, we've taken care of all the authentication parts.  You simply need to populate a basic Credentials object then launch an App auth request via an intent
from your Application.

What you must ensure is that your App has a callback uri defined, otherwise you won't be able to get the token returned from the API which you can use to make
authenticated API requests.  Under your apps page for your partners account, you'll have a "return URL" for your application.  This will need to be something custom
and hopefully namespaced such as:

> comexamplemyapplication://example

You'll also need to configure your Android manifest so that it responds to all uris that begin with //comexamplemyapplication//.  This can be done by adding something
similar to the following to your app:

>         <activity android:name=".MyShopifyAPICallbackActivity">
>            <intent-filter>
>	            <action android:name="android.intent.action.VIEW" />
>	            <category android:name="android.intent.category.DEFAULT" />
>	            <category android:name="android.intent.category.BROWSABLE" />
>	            <data android:scheme="comexamplemyapplication" />
>            </intent-filter>
>        </activity>

# Demo #

The included ShopifyProductsListDemo shows how to set up an application that will authorize against a users
Shopify store, calculate the API password for that store, fetch a list of products from a store and tell you
how many products it has.

The handshaking/OAuth-like aspect of the application was taken from [this tutorial](http://donpark.org/blog/2009/01/24/android-client-side-oauth).

# Known Issues #

* Trying to update information can lead to unexpected results.
* There are several dependencies which can lead to large applications.  It is in your best interest to
  get proguard working so you strip away any unused classes.