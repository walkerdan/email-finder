# email-finder
Email finder is used to find and record all email addresses associated with a given web site.
The program finds all email address on the given page and then recursively calls itself for 
any links to pages found on the current page.

### Outputs
Email finder generates the following outputs:
1. a file containing the discovered emails
1. a file containing the links to pages that were successfully read
1. a file containing the links to pages that were not successfully read

### Usage
java -jar email-finder.jar <a URL>

Example:

java -jar email-finder.jar http://cdm.depaul.edu

### Recent changes (5/14/2020)
1. Added ability to use local files.  Just provide complete path. ("file://" is not needed or expected).
1. Added max email parameter.  In a test of EmailFinder, it could look like this:
   
   EmailFinder.main(new String[] {"http://www.google.com", "3"});
   
   ... meaning it should stop after 3 email addresses are found.
   
### Recent changes (4/25/2020)
1. Now write out found email addresses, list of successful URLs, and a list of failed URLs
1. StorageService class was added to encapulated storage details
1. PageCrawler is now created with with 2 parameters: a StorageService and a maximum number of email addresses to find
1. The main method of EmailFinder was refactored to provide a run() method for easier testing

### TODO
1. Make app stop sooner.  With max emails set to 50, it still finds 90 emails
1. Clean up progress information