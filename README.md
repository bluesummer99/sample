# sample

A blade framework sample project.

# Run With IDE

```sh
git clone https://github.com/blade-samples/sample.git
```

use ide run `blade.sample.Application` main method.

# Run With Jar File

```sh
git clone https://github.com/blade-samples/sample.git
cd sample
mvn clean package assembly:single
java -jar target/dist/sample/sample-0.0.2.jar
```

You can Open the browser to access:

- GET		http://127.0.0.1:9000/
- GET		http://127.0.0.1:9000/index
- GET		http://127.0.0.1:9000/users/jack
- GET		http://127.0.0.1:9000/get
- GET		http://127.0.0.1:9000/hello
- GET		http://127.0.0.1:9000/users/blade
- GET		http://127.0.0.1:9000/api/person.json
- POST		http://127.0.0.1:9000/post
- POST		http://127.0.0.1:9000/save_user
- DELETE	http://127.0.0.1:9000/delete_user

