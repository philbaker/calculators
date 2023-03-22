(ns calculators.helpers.aspect-ratio
  (:require ["fraction.js" :as f]))

(defn decimal-to-fraction [decimal]
  (.toFraction (f/Fraction decimal)))

(defn fraction-to-decimal [fraction]
  (js/Number (.toString (f/Fraction fraction))))

(defn calculate-width 
  "Calculate width from aspect ratio and height"
  [height aspect-x aspect-y]
  (* height (/ aspect-x aspect-y)))

(defn calculate-height 
  "Calculate height from aspect ratio and width"
  [width aspect-x aspect-y]
  (/ width (/ aspect-x aspect-y)))

(defn calculate-ratio-decimal
  "Calculates ratio as decimal based on width and height"
  [height width]
  (/ height width))

(defn calculate-ratio-fraction
  "Calculates ratio as fraction based on width and height"
  [height width]
  (decimal-to-fraction (/ height width)))

(def common-ratios 
  [{:name "HD Video 16:9"
    :short-name "16:9"
    :ratio-width 16 
    :ratio-height 9
    :pixel-width 1280
    :pixel-height 720}
   {:name "Standard Monitor 4:3"
    :short-name "4:3"
    :ratio-width 4 
    :ratio-height 3
    :pixel-width 1280
    :pixel-height 960}
   {:name "Classic Film 3:2"
    :short-name "3:2"
    :ratio-width 3 
    :ratio-height 2
    :pixel-width 1280
    :pixel-height 853.33}
   {:name "Cinemascope 21:9"
    :short-name "21:9"
    :ratio-width 21 
    :ratio-height 9
    :pixel-width 1280
    :pixel-height 548.57}])
