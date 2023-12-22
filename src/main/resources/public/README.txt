You can assign a folder in the classpath serving static files with the staticFiles.location() method.

Note that the public directory name is not included in the URL.

A file /public/css/style.css is made available as http://{host}:{port}/css/style.css

staticFiles.location("/public");

root is 'src/main/resources', so put static files in 'src/main/resources/public'

You can also assign an external folder (a folder not in the classpath) to serve static files by using the staticFiles.externalLocation() method.

staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));

Static files location must be configured before route mapping. If your application has no routes, init() must be called manually after location is set.
