resources = ["Asset", "Blog", "Collect", "Comment", "Country", "CustomCollection", "Customer", "CustomerGroup", "Event", "Fulfillment", "Metafield", "Order", "Page", "Product", "ProductSearchEngine", "Province", "Redirect", "ScriptTag", "Shop", "SmartCollection", "Theme", "Transactions", "Webhook"]

resources.each do |res|
  File.open("#{res}/single#{res}.json", 'wb'){|f| f.write("")}
end
