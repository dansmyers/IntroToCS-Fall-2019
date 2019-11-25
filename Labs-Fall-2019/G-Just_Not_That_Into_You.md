# Just Not That Into You

## Description

***Thanks to Mariah Haskell for coming up with the idea for this lab.***

We're going to write an **automated rejection app** that will give you the ability to passive-aggressively reject people that you are
**Just Not That Into**. When someone calls or texts a special phone number, your app will automatically respond with a rejection message
and encourage the rejected party to continue having a nice life.

To do this, we're going to play with Twilio, a company that provides programmable SMS text messaging and phone calls over the Internet.

Here's the basic idea:

1. You sign up for Twilio and get a trial account with a demo phone number managed by Twilio (the instructions are below).

2. When a call or text comes to that phone number, Twilio **automatically sends an HTTP message to a server that you control**.

3. Your server receives the message, which can contain information about the text or call, and runs code to handle it.

4. In our examples, our handler code will use Twilio's **Application Programming Interface** (API) to send texts back and 
automatically generate voice responses.


## Sign up for Twilio

### Create an Account
Go to the Twilio home page and sign up for an account. You'll need to enter your own phone number and receive a validation code to prove that you're a real person.

Twilio's service is not free, but the trial account gets you about $15 of credit. Sending a text costs, like, $.0075, and getting an activated phone number is $1, so you'll be able to send close to 2000 texts on the trial, which should be more than enough for us. 

Another practical limitation of the intro trial: you're only allowed to text your own phone number that you used in the account setup process. Unfortunately, this means that the only person you can reject using the app is yourself.

### Get Your Number
First, create a new project.
- The project-creation page brings up a list of templates that you can choose between. 

- Instead of picking one of those, select "Products" at the top of the page.

- Then click on "Programmable SMS" and "Phone Numbers" so that they're highlighted.

- Click on the "Continue" button at the bottom of the page to create the workspace. You can choose any name for the workspace.

Once you're on the main project dashboard, scroll down and click on "Get a Number" under the "Phone Numbers" section. You'll be offered a number (it might be in the same area code as your phone number, but it doesn't have to be), which you can accept.

You're now ready to write some code.


## Text

### Get the Dependencies

Remember the `pom.xml` file that told Maven how to build Spring Boot projects? Remember how I told you to **never, ever edit** `pom.xml`?
Well, to get access to Twilio's API classes you have to do the unthinkable and **edit `pom.xml`**.

Open the file in your Mimir IDE. Scroll down to find the `<dependencies>` tag. Inside the tag, place the following block:

```
<dependency>
    <groupId>com.twilio.sdk</groupId>
    <artifactId>twilio</artifactId>
    <version>7.45.1</version>
    <scope>compile</scope>
</dependency>
```

Briefly, this chunk of XML code tells Maven to load a set of classes from Twilio (`com.twilio.sdk`) as part of the build process. It
specifies that we want to load version 7.45.1 of the SDK ("software development kit").

### The Code

Open up `Controller.java`, the same file we used in the previous labs.

Add the following imports to the top of the file:

```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
```

Add the following method to the class body:

```
   @GetMapping(path="/text")
   public void sendText() {
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

       Message message = Message.creator(
           new PhoneNumber("+15555555555"),  // To number
           new PhoneNumber(TWILIO_NUMBER),  // From number
           "This is an automated message. The person you are trying to reach is just not that into you. Have a nice life." // SMS body
        ).create();

        System.out.println(message.getSid());
   }
```

Take a look at this code for a moment. I'll wait.

Okay, welcome back.

It's pretty similar to our previous web programming examples. The first line defines a **route** with the URL `/text`. When an HTTP
request comes in to that URL path, the Spring Boot framework will run the code in the `sendText` method.

There are really only two things happening here:

- The first line of the method uses the `Twilio` class to authenticate your account. We'll add three more lines to complete the authentication process in just a second.

- The second line uses Twilio's `Message` class to construct and send a text message.

**Put your own phone number between the quotes where it says `To number`.


### Authenticate

As you might expect, Twilio doesn't let just anyone send messages using their API.

Add the next three lines to the top of your class body, before any of the methods:

```
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "FILL IN YOUR ACCOUNT SID HERE";
    public static final String AUTH_TOKEN = "FILL IN YOUR ACCOUNT AUTH TOKEN HERE";
    public static final String TWILIO_NUMBER = "+15555555555";
```

Go back to your Twilio dashboard and copy the Account SID and Account Token into the code you just pasted. The values will be in the 
upper right of your dashboard and will both be long random strings. Twilio uses these two pieces of info to authenticate that you're a valid user with a real account.

Put your assigned Twilio phone number in the third `String`.

### Build the App

Compile your app again.

```
./mvnw clean package
```

Fix any minor syntax errors that occur. If you get a more complicated error, let me know so I can check the `pom.xml` file.

**Don't run the server yet**. We need to fix one more detail before Twilio is ready to communicate with your code.

## Webhooks

### Concept

Twilio's service manages the phone number that it has assigned to you. Therefore, when someone calls or texts that number, the request
comes in to Twilio's system.

Twilio then fires off an HTTP message to a URL that you specify, which is associated with code that handles the call or text. This is a
pretty cool system, because it lets you write programs that can communiciate with a user via text messages.

For example, you can create automated surveys or even interactive help systems that respond over text. Once we work with voice, you can
also build interactive phone trees.

### `ngrok`

There's one technical issue we need to overcome first: **Twilio cannot directly contact the server running on Mimir**.

Fortunately, there's a pretty simple workaround using a program called `ngrok`, which is essentially a cloud-based forwarding program:

- You run your webserver on Mimir, the same as we've done for other projects.

- You also run `ngrok`, which we'll download in just a moment.

- `ngrok` creates a tunnel connecting your local webserver to another URL that it manages.

- You give `ngrok`'s URL to Twilio, which it can contact without any issues, but behind the scenes `ngrok` is routing all traffic it
receives to your own server, which is exactly what we want.

Open a new terminal (`File --> New Terminal`). In the new window, download the `ngrok` application using the `curl` program, which can
retrieve files from another location (the `-O` flag is a **capital letter O**):

```
curl -O https://bin.equinox.io/c/4VmDzA7iaHb/ngrok-stable-linux-amd64.zip
```

Unzip it:

```
unzip ngrok-stable-linux-amd64.zip
```

And run a command telling `ngrok` to forward HTTP traffic on port 80:

```
./ngrok http 80
```

`ngrok` will bring up a display in the terminal window. Look at the last line that says `Forwarding`, which will show a URL
beginning with `https`. It will look something like this, but yours will be unique:

```
https://dc3b3e95.ngrok.io
```

Highlight that URL and copy it.

### Configure the Webhook on Twilio

Now (finally) we can connect Twilio to our server.

From your dashboard, click on the `#` symbol in the left side, then click on your phone number.

Scroll down to where it says "Messaging" and find the box that says "A Message Comes In".

Paste your `ngrok` URL into the box and add `/text` to the route:

```
https://dc3b3e95.ngrok.io/text
```

(Again, this is my example. You'll use your unique URL.)

If the selection box to the right says `POST`, change it to `GET`.

Click "Save" at the bottom of the page.


## Fire It Up

Go back to your main terminal window. Run your server using the `jar` file:

```
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

Once the server starts, you can text your Twilio phone number. 

```
Yo
```

Have a nice life!


## The Voice

Let's play another trick. What if the person you want to ghost decides to call you instead of texting?

Add the following imports to `Controller .java`:

```
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Play;
import com.twilio.twiml.voice.Say;
```

Add another method to handle calls:

```
    @GetMapping(path="/call", produces="application/xml")
    @ResponseBody
    public String respondToPhoneCall() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        VoiceResponse.Builder voiceBuilder = new VoiceResponse.Builder();

        Say greeting = new Say.Builder("This is an automated message. The person you are trying to call is just not that into you. Have a nice life.").build();

        return voiceBuilder.say(greeting).build().toXml();
   }
```

This method is very similar to the previous example. The major difference is that this method **returns a response** back to Twilio.

Handling voice calls is fundamentally **synchronous**. Twilio's system is holding the call open while it waits for your server to respond. In this case, our method returns a special XML message that Twilio can use to play a synthesized voice message.

Add a new route to your phone number's page, under the "Voice" section:

```
https://dc3b3e95.ngrok.io/call
```

(Once again, you'll use your unique `ngrok` URL.)

Stop your server by pressing CTRL + C. You can leave `ngrok` running in its own terminal tab. Rebuild and re-run your server:

```
./mvnw clean package
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

Now call your Twilio phone number. You'll get a brief message about having a trial account before being prompted to press a button.
Press any key and revel in getting dumped by your computer.

