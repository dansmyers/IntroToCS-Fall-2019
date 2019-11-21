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

### Serve the Page

Build and run your web application using the commands from the last lab:

```
./mvnw clean package
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

Visit the page and verify see what happens when you type in the box and click the button.

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

## Fortune

Modify the `<script>` section of the page to print a random fortune when the user clicks the button.

Change the code inside the `function` block to pick a random number between 0 and 1 and then use it to load a message into the `<div>`.

```
var r = Math.random();  // JS random number function has the same name as Java

if (r < .3333) {

    // Use document.getElementById to load a message into the div

} else if (r < .6666) {

    // Use document.getElementById to load a different message into the div

} else {

    // Use document.getElementById to load a third message into the div

}
```

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


## Bootstrap

The pages you've built up to this point have worked fine, but suffer from one obvious problem: **they look like total garbage**.

To spruce things up a bit, we're going to introduce Bootstrap, the most popular framework for designing responsive front end web pages.
Bootstrap was created at Twitter, so it's sometimes called **Twitter Bootstrap**, but it's no longer directly managed by that company.

Bootstrap does a few nice things for you:

- It gives you a set of default page styles that look decent. Bootstrap also includes a lot of built-in styles for elements like buttons and input boxes.
- It allows you to easily create a structured row-and-column layout for your page content.
- It is **responsive**, which means that it automatically resizes and rearranges the page elements based on the size of the viewing a window. **This is extremely helpful** because it means that same page can automatically reconfigure itself and look good on desktop, mobile, or any other device.

### Example Page

Change your `index.html` page to the following. This page seems a lot longer, but it's not that complex.

After you update the page, view it in your browser.

```
<!DOCTYPE html>
<html lang="en">
    <head>
      
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <title>Bootstrap Starter Page</title>
  
        <style>
     
            // Additional CSS formatting goes here

        </style>
  
    </head>
  
    <body>
    
        <!-- Jumbotron makes a big banner heading at the top of the page -->
        <div class="jumbotron">

            <h1 class="display-1">
                Jumbotron!
            </h1>

        </div>

    
        <!-- Page content goes inside this container -->
    
        <div class="container">

            <!-- All content is organized into a series of rows -->
            <div class="row">

                <!-- Columns span a portion of the row -->
                <div class="col-md-4">

                    <h1>Hello</h1>

                    <p>
                        This is an example Bootstrap page.
                    </p>
                    
                    <p>
                        This column spans four of the twelve units in the row. The other column spans the other eight of twelve units.
                    </p>

                </div>



                <div class="col-md-8">

                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Tsunami_by_hokusai_19th_century.jpg/2560px-Tsunami_by_hokusai_19th_century.jpg" width="100%"/>
                    
                    <p>
                        Notice how the image's width is automatically scaled to the width of its column.
                    </p>

                </div>


            </div>  <!-- End of row -->
        

            <!-- A second row -->
	        <div class="row">

                 <div class="col-md-12">
                      <h1>
                           This is a single column that spans all twelve units.
                       </h1>
                  </div>
                
            </div> <!-- End of second row -->
        
                
        </div>  <!--- end container -->

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
    </body>

</html>
```

The page is divided into three rows:

1. The top-level callout with huge text. Bootstrap calls this a **Jumbotron**.

2. The first row of content, which is split into two columns. The left column spans one-third of the page. The right column spans two-thirds of the page and contains an `<img>` tag.

3. The second row of content, which is organized as one column that spans the entire page.

### Resize

Try resizing your brower window. What happens to the page elements as you shrink the window? You can even try going to your page on your phone (by manually typing the URL into your browser bar) and seeing how it looks.

### Bootstrap's Grid System

**Everything in Bootstrap is organized around a series of rows and columns**.

Every row is a `<div class="row">` element. Inside the row `<div>` are one or more `<div>` elements that represent the columns.

**All of the columns must be inside a row `div` and all of the rows must be inside a single container `div`**. If you're Bootstrap page
looks really weird, chances are that some content has somehow slipped outside of the container-row-column framework.

Every Boostrap row is conceptually divided into **twelve column units**. You can make columns that span any subset or combination of those twelve units.

Here is an example from the demo page you just viewed:

```
            <!-- All content is organized into a series of rows -->
            <div class="row">

                <!-- Columns span a portion of the row -->
                <div class="col-md-4">

                    <h1>Hello</h1>

                    <p> This is an example Bootstrap page.</p>
                    
                    <p> This column spans four of the twelve units in the row. The other column spans the other eight of twelve units.</p>
                </div>


                <div class="col-md-8">

                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Tsunami_by_hokusai_19th_century.jpg/2560px-Tsunami_by_hokusai_19th_century.jpg" width="100%"/>
                    
                    <p> Notice how the image's width is automatically scaled to the width of its column.</p>

                </div>

        </div>  <!-- End of row -->
```

Take a look at the columns:

- The first column is identified by a `<div class="col-md-4">` tag. The `4` makes it span four of the twelve units, so it takes up one-third of the total row.

- The second column is identified by a `<div class="col-md-8">` tag. The `8` makes it span four of the twelve units, so it takes up one-third of the total row.

### Add a Row

Add the following to the page. Put it **below** the end of the second row, but still inside the container `div`.


```
<!-- Third row: each column takes up half the width -->
<div class="row">

    <div class="col-md-6">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Tsunami_by_hokusai_19th_century.jpg/2560px-Tsunami_by_hokusai_19th_century.jpg" width="100%"/>        
    </div>
    
    <div class="col-md-6>
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Tsunami_by_hokusai_19th_century.jpg/2560px-Tsunami_by_hokusai_19th_century.jpg" width="100%"/>       
    </div>

</div> <!-- End of third row -->
```

Reload the page and you'll see that a new row with two images has appeared at the bottom of the page.


## Put It All Together

Update `index.html` one more time to the following page.

```
<!DOCTYPE html>
<html lang="en">
    <head>
      
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <title>Bootstrap Starter Page</title>
  
        <style>
     
            // Additional CSS formatting goes here

        </style>
  
    </head>
  
    <body>
    
        <!-- Jumbotron makes a big banner heading at the top of the page -->
        <div class="jumbotron">

            <h1 class="display-1">
                Hello!
            </h1>
            
            <p class="lead">
                This page combines all of the essential elements of web programming.
            </p>

        </div>

    
        <!-- Page content goes inside this container -->
    
        <div class="container">

            <!-- All content is organized into a series of rows -->
            <div class="row">

                <!-- Columns span a portion of the row -->
                <div class="col-md-6">

                    <h1>Hello!</h1>

                    <p>Type your name in the box below and click the button.</p>

                    <input type="text" class="form-control" id="inputBox">
          
                    <button class="btn btn-primary" type="button" id="submitButton">
                        Submit
                    </button>
                </div>



                <div class="col-md-6">

                    <div id="responseDiv">
                        
                    </div>

                </div>


        </div>  <!-- End of row -->
        
                
        </div>  <!--- end container -->
        
        
        <!-- Page element scripts -->
         <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                // Create and send an HTTP request
                var oReq = new XMLHttpRequest();
                oReq.addEventListener("load", responseListener);
                oReq.open("GET", "https://nostalgic-dellingr_80.ide.mimir.io/hello?name=" + input);
                oReq.send();
            }

            // Listener runs when the server's response comes back
            function responseListener() {
                document.getElementById('responseDiv').innerHTML = this.responseText;
            }
        </script>

        <!-- Required Bootstrap scripts -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>

</html>
```


This demo shows off all of the essential elements we've developed in one page:

- Your Java Spring Boot server returns the page when the user visits the site.
- It uses Bootstrap for a grid-based layout.
- It has an input box and button.
- Clicking the button runs a short script that takes the string from the text box and sends it to the server.
- The server processes your input and returns a response.
- The page then uses the server response to update its own content.

This example is not complex, but you can see how it combines everything you need to make more full-featured applications.

## I CAN HAZ?

Try out one more example page. The script code is a little more complex than the previous example, but all of the
essential elements are the same. Look through the code and examine how the different parts of the page interact.

Here are some image URLs for you to use:

```
https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Ducreux1.jpg/1280px-Ducreux1.jpg

https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/The_lake_of_Hakone_in_the_Segami_province.jpg/2560px-The_lake_of_Hakone_in_the_Segami_province.jpg
```

```
<!doctype html>
<html>
    
    <head>
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <style>
            canvas {
                width: 100%;
                height: auto
            }
        </style>
    </head>
    
    
    <body>
        
        <div class="jumbotron jumbotron-fluid bg-light">
           <div class="container">

                <!-- The display classes make text big -->
                <h1 class="display-4">
                    CMS 167 Meme Generator
                </h1>
               
               <p class="lead">
                   DO NOT CREATE ANY DR. MYERS MEMES
               </p>
            </div> <!-- container -->
        </div>
        

        <!-- Recall: all Bootstrap content must be enclosed in a container div -->
        <div class="container">
            <div class="row">
                
                <div class="col-md-6">
                    <canvas id="canvas" width="640" height="480">
                        Sorry, your browser doesn't support the &lt;canvas&gt; element.
                    </canvas>
                </div> <!-- /col-md-6 -->
                
                <div class="col-md-6">
                    
                    <label for="imageURL">Image URL</label>
                    <input type="text" class="form-control" id="imageURL" placeholder="Enter the URL of the image you want to meme.">
                             
                    <label for="memeText" class="mt-4">Meme Text</label>
                    <input type="text" class="form-control" id="memeText" placeholder="Put your meme text here.">
                                          
                    <!-- Radio button group -->
                    <div class="btn-group btn-group-toggle mt-4" data-toggle="buttons">
                        <label class="btn btn-outline-primary active">
                            <input type="radio" name="positions" value="bottom" autocomplete="off" checked> Text at Bottom
                        </label>
                        <label class="btn btn-outline-primary">
                            <input type="radio" name="positions" value="top" autocomplete="off"> Text at Top
                        </label>
                    </div>
                               			       
                    <button class="btn btn-primary btn-block mt-4" type="button" id="generateButton">
                        Generate Meme
                    </button>
           
                </div> <!-- /col-md-6 -->

            </div> <!-- /row -->
   
        </div> <!-- /container -->
        
	<!-- Script that performs the meme generation work -->
        <script>
            // Get a reference to the canvas's drawing context
            // context provides all drawing functions
            var canvas = document.getElementById("canvas");
            var context = canvas.getContext("2d");
            
	    // Set a function that runs on a button click
            var button = document.getElementById("generateButton");
            button.onclick = function() {
                
                // Get the source URL from the input box
                var inputBox = document.getElementById("imageURL");
                var url = inputBox.value;
            
                // Create a new Image and assign it a source URL
                var img = new Image();
                img.src = url;
            
                // You can't draw the image until it's loaded
                // This function runs when the image is ready
                img.onload = function() {
                    // Set canvas size to image size
                    // Scales canvas up if image is larger than default in either dimension
                    canvas.width = 640;
                    canvas.height = 480;
                    canvas.width = Math.max(canvas.width, img.width);
                    canvas.height = Math.max(canvas.height, img.height);                  
                
                    // Draw the image
                    // (0, 0) is the upper-left corner of the canvas
                    context.drawImage(img, 0, 0, img.width, img.height);
                    
                    // Set up and draw text
                    // Black outline first, then white filled
                    var text = document.getElementById("memeText").value;
                    var textX = img.width / 2;  // Center text within image
                    
                    // Select height using radio buttons
                    var position = document.querySelector('input[name="positions"]:checked').value;
                    if (position == "bottom") {
                        textY = img.height * .80;
                    } else {
                        textY = img.height * .20;
                    }
                    
                    var fontSize = .10 * img.width;  // Scale font based on image width                    
                    context.font = fontSize + "px Impact";  // Font string
                
                    context.textAlign = "center";  // Center text on x position
  
                    context.strokeStyle = 'black';
                    context.lineWidth = .10 * fontSize;  // Width of black outline
                    context.miterLimit = 2;  // Controls outline artifacts
                    context.strokeText(text, textX, textY);  // Write black outline

                    context.fillStyle = "white";
                    context.fillText(text, textX, textY);  // Write white text
                }
            }
        </script>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
    
</html>
```
