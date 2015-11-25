# primes-scalatra-app-loadtests

very straightforward load test simulation for [primes ui webapp](https://github.com/dacr/primes-scalatra-app).

Available load test parameters (environment variable or java properties )

* general parameters :
  * `PRIMESUI_URL` : primes ui web app URL (default to http://localhost:8080/primesui)
  * `PRIMESUI_VUS` : number of virtual users for the load test simulation (default is 2000)
  * `PRIMESUI_LOADTEST_DURATION` : Load test duration in minutes (default is 5 minutes)
  * `PRIMESUI_CHECKTYPE` : change the check implementation, default is set to `check`. Available choices are :
    * `issuecheck`
    * `highcpucheck`
    * `overcheck`
    * `slowcheck`
    * `slowsqlcheck`
    * `toomanylogscheck`
    * `badlogscheck`
    * `goodlogscheck`
    * `leakedcheck`
    * `sessionleakedcheck`
    * `jdbcleakcheck`
* assertion parameters (if not set, it does not apply):
  * `PRIMESUI_ASSERT_MAX_RESPTIME` : mean response time limit
  * `PRIMESUI_ASSERT_MAX_RESPTIME50` : 50 percentile response time limit
  * `PRIMESUI_ASSERT_MAX_RESPTIME75` : 75 percentile response time limit
  * `PRIMESUI_ASSERT_MAX_RESPTIME95` : 95 percentile response time limit
  * `PRIMESUI_ASSERT_MAX_RESPTIME99` : 99 percentile response time limit
  * `PRIMESUI_ASSERT_OK_PERCENT` : successfull request percent
  * `PRIMESUI_ASSERT_MIN_HITRATE` : minimal achieved request hit rate

