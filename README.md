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

### TODO
1. Currently only outputs the email addresses, not the URL lists
1. Make max emails configurable (currently hard coded to 50).
1. Make app stop sooner.  With max emails set to 50, it still finds 90 emails
1. Clean up progress information