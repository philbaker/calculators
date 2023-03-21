(ns calculators.helpers.pixel)

(defn pixel-to-rem [val]
  (/ val 16))

(defn rem-to-pixel [val]
  (* val 16))
