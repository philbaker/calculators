(ns calculators.helpers.aspect_ratio_test
  (:require [clojure.test :as test]
            [calculators.helpers.aspect-ratio :as a]))

(test/deftest fraction-to-decimal
  (test/is (= (a/fraction-to-decimal "1/2") 0.5)))

(test/deftest decimal-to-fraction
  (test/is (= (a/decimal-to-fraction 0.5) "1/2"))
  (test/is (= (a/decimal-to-fraction 
                (a/fraction-to-decimal 
                  (a/decimal-to-fraction 0.5))) 
              "1/2")))

(test/deftest calculates-width-from-aspect-ration-and-height
  (test/is (= (a/calculate-width 50 2 1) 100)))

(test/deftest calculates-height-from-aspect-ration-and-width
  (test/is (= (a/calculate-height 100 2 1) 50)))

(test/deftest calculates-decimal-ratio-from-width-and-height
  (test/is (= (a/calculate-ratio-decimal 50 100) 0.5)))

(test/deftest calculates-fraction-ratio-from-width-and-height
  (test/is (= (a/calculate-ratio-fraction 50 100) "1/2")))

(comment
  (test/run-tests)
  )
