(ns calculators.helpers.util)

(defn round-number 
  "Rounds a number to two decimal places"
  [x]
  (/ (.round js/Math (* 100 x)) 100))


