# Just Not That Into You

## Description

***Thanks to Mariah Haskell for coming up with the idea for this lab.***

We're going to write an **automated rejection app** that will give you the ability to passive-aggressively reject people that you are
Just Not That Into. When someone calls or texts a special phone number, your app will automatically respond with a rejection message
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

Twilio's service is not free, but the trial account gets you about $15 of credit. Sending a text costs, like, $.0075, and getting an activated phone number is $1, so you'll be able to send close to 2000 texts on the trial, which should be more than enough for us. Another practical limitation of the intro trial: you're only allowed to text your own phone number that you used in the account setup process.

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

Open the file in your Mimir IDE.




### `ngrok`


### Configure the Webhook on Twilio







## Call
