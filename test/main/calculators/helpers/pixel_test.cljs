(ns calculators.helpers.pixel_test
  (:require [clojure.test :as test]
            [calculators.helpers.pixel :refer [pixel-to-rem rem-to-pixel]]))

(test/deftest returns-correct-value-after-conversion
  (test/is (= (pixel-to-rem 16) 1))
  (test/is (= (rem-to-pixel 1) 16)))

(comment
  (test/run-tests)
  (test/run-all-tests)
  )
