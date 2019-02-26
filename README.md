# Scoverage Multi-Module Aggregate Reports With Jenkins    

The custom discipline plugin isn't needed, I just threw it in.

## Test Locally
Run

    sbt clean coverage test coverageReport coverageAggregate
    
This is set up with intentionally coverage less than the configured `coverageMinimum := 90`.
Additionally, this sets `coverageFailOnMinimum := false` to generate the reports, showing the failure,
 versus fail completely. 
 
* If you have a huge project with nightly jobs that run tests for a few hours,
 `coverageFailOnMinimum := false` 
* If you have a small project and want the reports or aggregation run often, failing fast,
 `coverageFailOnMinimum := true` may be a better fit. 

## Jenkins Setup
* Create or edit a Jenkins job for your repo.
* Configure your SBT build tasks in the Jenkins job
 
 
    clean coverage test coverageReport coverageAggregate
    
      
## Scoverage Jenkins Plugin     
Additionally, you can also:

* Add the Scoverage Jenkins plugin 
* Add an Scoverage task to the Jenkins job, configuring:
    
    
      Publish Scoverage Report
 	  Scoverage Report Directory	target/scala-{version}/scoverage-report	
 	  Scoverage Report File	        scoverage.xml