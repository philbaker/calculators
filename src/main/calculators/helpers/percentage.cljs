(ns calculators.helpers.percentage)

(defn percentage-as-number
  "x is what % of y"
  [x y]
  (* (/ x 100) y))

(defn number-as-percentage 
  "what is x% of y"
  [x y]
  (* (/ x y) 100))

(defn percentage-change
  "what is the % increase/decrease from x to y"
  [x y]
  (if (> x y)
    (- (* (/ (- x y) x) 100))
    (* (/ (- y x) x) 100)))
