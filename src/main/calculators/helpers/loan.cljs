(ns calculators.helpers.loan
  (:require [calculators.helpers.util :refer [round-number]]))

(defn monthly-loan-repayment [rate num-payments loan-amount]
  (if (= rate 0)
    (/ loan-amount num-payments)
    (let [interest-factor (js/Math.pow (+ 1 rate) num-payments)
          payment-amount (* rate (/ (* loan-amount interest-factor) 
                                    (- interest-factor 1)))]
      (round-number payment-amount))))

(defn num-payments [years]
  (* years 12))

(defn annual-rate [rate]
  (/ rate 100 12))

(comment
  (monthly-loan-repayment
    (annual-rate 4.19)
    (num-payments 21)
    4200000)
  )
