# How to Front End

## Description

This lab will show off some of the basic techniques for building interactive pages on the front end of a web application.

We're going to experiment with:

- Creating input fields and buttons on a page
- Giving names to those fields and buttons
- Using `document.getElementById` to assign a listener function to a button
- Using `<div>` elements
- Using `XmlHttpRequest` to send a request to the server

Note: I don't expect you to memorize everything that's in this example. Our focus right now is on understanding the flow of what happens
when the user clicks on the button, and how the front and back ends of the tiny application interact with each other.

## Interact

Update `index.html` to the following. This code introduces several new elements.

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>CMS 167 Demo</title>
    </head>

    <!-- Body contains the page's content -->
    <body>
        <h1>Input</h1>

        <p>Type your name in the box below and press Submit.</p>

        <input type="text" id="inputBox" />
        <button type="button" id="submitButton"> Submit </button>

        <!-- The div tag creates a named region of the page -->
        <div id="responseDiv"></div>

        <!-- script tag contains JavaScript that interacts with page elements -->
        <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                // Copy it to the response field
                document.getElementById('responseDiv').innerHTML = input;
            }
        </script>
    </body>
</html>
```

First, notice that there are two input elements. One is a text box and the other is a button. Each element has an `id` field, which
assigns a name that can be used to interact with the element.

The third page element is a `div`, which you can think of as a page division. The `div` tag creates a labeled region of the page that
has an `id`, so that you can interact with it later. This `div` is going to be used to print a response message from
the server.

### JavaScript

The page has a `script` tag located inside the `body`. The content of the `script` is JavaScript. Notice that the commenting style
changes from HTMl to Java-style comments within the tag.

A basic JavaScript action is `document.getElementById`, which lets you retrieve a reference to a page element by specifying its `id`
string. Notice the capitalization of `Id`; it's not `ID`!

The script illustrates three things you can do with page elements.

1. The first line assigns a function to the button element's `onclick` property. The code in this function runs when the user clicks
the button. Notice that the function is **anonymous**: it doesn't have a name. This style is very common in JavaScript programming.

2. The second call gets the current string typed in the text box by reading its `value` property in conjunction with `getElementById`.

3. The third call sets the content of the `responseDiv` element by setting its `innerHTML` property.

Clearly, this style of programming requires you to know what properties and fields are available for each element. These are standardized as part of the HTML specification, but, in practice, you will often end up doing documentation searches to figure out exactly what field to read or set for a particular element to get the effect you want.

## Send and Receive

Now, we're going to add one more element to the JavaScript code: a call that sends information from the page to the server and receives a response.

The feature that implements this behavior is called `XmlHttpRequest`. An `XmlHttpRequest` object represents an HTTP communication with
a server. It specifies the target server URL and any body text or parameters that go along with the message. It also specifies a
listener function that will run when the client receives the server's response returns.

The style of programming that developed around `XmlHttpRequest` is called AJAX, which stands for *Asynchronous JavaScript and XML*.

- It is *asynchronous* because the client specifies a listener function that will run and handle the server's response when it arrives. The client does not have to block and wait while the request is in process. Further, it lets you process the server's response and udpate part of the interface *without reloading the entire page*.

- XML ("Extensible Markup Language") is an HTML-like markup variant that allows for arbitrary tags around data items. It is useful, but verbose. The original AJAX implementations used XML to structure data passed between clients and servers. Nowadays, there are other, more compact options for passing values. One of the most popular is *JavaScript Object Notation* (JSON), which is a text-based representation of a JavaScript object.

First, modify your `/hello` method in `Controller.java` so that it can access a parameter.

```
@RequestMapping("/hello")
public String hello(@RequestParam(value="name", defaultValue="World") String name) {
    return "Hello, " + name + "!";
}
```

Next, update `index.html` to the following:

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>CMS 330 REST Demo</title>
    </head>

    <!-- Body contains the page's content -->
    <body>
        <h1>Input</h1>

        <p>Type your name in the box below and press Submit.</p>

        <input type="text" id="inputBox" />
        <button type="button" id="submitButton"> Submit </button>

        <!-- The div tag creates a named region of the page -->
        <div id="responseDiv"></div>

        <!-- script tag contains JavaScript that interacts with page elements -->
        <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                // Create and send an HTTP request
                var oReq = new XMLHttpRequest();
                oReq.addEventListener("load", responseListener);
                oReq.open("GET", "https://YOUR_MIMIR_SITE_NAME.io/hello?name=" + input);
                oReq.send();
            }

            // Listener runs when the server's response comes back
            function responseListener() {
                document.getElementById('responseDiv').innerHTML = this.responseText;
            }
        </script>
    </body>
</html>
```

Once again, change `YOUR_MIMIR_SITE_NAME` to the name of your Mimir web page.

Close your current server with `CTRL + c`, then compile and run the server again:

```
./mvnw clean package
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

The new code is fairly simple. One key detail: the parameter (`name`) is passed to the server *as part of the URL*.

In this style, the overall HTTP method is `GET`, which implies that the request does not have a body, but the URL has been extended with a `?` followed by a set of name-value parameter pairs.
