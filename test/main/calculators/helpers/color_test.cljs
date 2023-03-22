(ns calculators.helpers.color_test
  (:require [clojure.test :as test]
            [calculators.helpers.color :as c]))

(test/deftest hex-to-rgb
  (test/is (= (c/hex-to-rgb "#fff") [255 255 255])) 
  (test/is (= (c/hex-to-rgb "#FFF") [255 255 255])) 
  (test/is (= (c/hex-to-rgb "#ffffff") [255 255 255])) 
  (test/is (= (c/hex-to-rgb "#FFFFFF") [255 255 255])) 
  (test/is (= (c/hex-to-rgb "#000") [0 0 0])) 
  (test/is (= (c/hex-to-rgb "#000000") [0 0 0])))

(test/deftest hex8-to-rgba
  (test/is (= (c/hex8-to-rgba "#ffffff80") [255 255 255 0.5])) 
  (test/is (= (c/hex8-to-rgba "#FFFFFF80") [255 255 255 0.5])) 
  (test/is (= (c/hex8-to-rgba "#000000bf") [0 0 0 0.75])))

(test/deftest rgb-to-hex
  (test/is (= (c/rgb-to-hex [255 255 255]) "#ffffff")) 
  (test/is (= (c/rgb-to-hex [0 0 0]) "#000000"))
  (test/is (= (c/rgb-to-hex (c/hex-to-rgb "#FFF")) "#ffffff")))

(test/deftest rgba-to-hex8
  (test/is (= (c/rgba-to-hex8 [255 255 255 0.5]) "#ffffff80")) 
  (test/is (= (c/rgba-to-hex8 [0 0 0 0.75]) "#000000bf")))

(test/deftest css-formatting
  (test/is (= (c/rgb-format-css [255 255 255]) "rgb(255, 255, 255)"))
  (test/is (= (c/rgb-unformat-css "rgb(0, 0, 0)") [0 0 0]))
  (test/is (= (c/rgba-format-css [255 255 255 0.5]) "rgba(255, 255, 255, 0.5)"))
  (test/is (= (c/rgba-unformat-css "rgba(0, 0, 0, 0.5)") [0 0 0 0.5]))
  (test/is (= (c/rgba-format-css (c/hex8-to-rgba "#ffffff80")) "rgba(255, 255, 255, 0.5)")))

(test/deftest handle-short-hex
  (test/is (= (c/handle-short-hex "#000") "#000000"))
  (test/is (= (c/handle-short-hex "#ff0") "#ffff00")))

(test/deftest decimal-to-hex
  (test/is (= (c/decimal-to-hex 1) "ff"))
  (test/is (= (c/decimal-to-hex 0.75) "bf"))
  (test/is (= (c/decimal-to-hex 0.5) "80"))
  ; prefixes a 0 when hex value is 1 character
  (test/is (= (c/decimal-to-hex 0.05) "0d")))

(comment
  (test/run-tests)
  )
