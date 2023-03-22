(ns calculators.helpers.loan_test
  (:require [clojure.test :as test]
            [calculators.helpers.loan :as l]))

(test/deftest returns-correct-monthly-payment
  (test/is (= (l/monthly-loan-repayment
                (l/annual-rate 6)
                (l/num-payments 30)
                400000) 
              2398.2)))

(comment
  (test/run-tests)
  )
