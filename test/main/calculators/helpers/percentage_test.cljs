(ns calculators.helpers.percentage_test
  (:require [clojure.test :as test]
            [calculators.helpers.percentage :as p]))

(test/deftest returns-correct-value-after-conversion
  (test/is (= (p/percentage-as-number 5 10) 0.5))
  (test/is (= (p/number-as-percentage 5 10) 50))
  (test/is (= (p/percentage-change 5 10) 100)))

(comment
  (test/run-tests)
  )
