resources = ["Asset", "Blog", "Collect", "Comment", "Country", "CustomCollection", "Customer", "CustomerGroup", "Event", "Fulfillment", "Metafield", "Order", "Page", "Product", "ProductImage", "ProductVariant", "ProductSearchEngine", "Province", "Redirect", "ScriptTag", "Shop", "SmartCollection", "Theme", "Transactions", "Webhook"]

resources.map{|res|
  File.open("#{res}/single#{res}.json", 'wb'){|f| f.write("")}
}