(ns calculators.helpers.color
  (:require [cljs.reader :as c]
            [clojure.string :as str]
            [calculators.helpers.util :refer [round-number]]))

(defn handle-short-hex 
  "Converts a 3 char hex to the equivalent 6 char version"
  [hex-code]
  (let [hex (rest hex-code)]
    (if (= (count hex) 3) 
      (->> hex
           (map #(repeat 2 %))
           (flatten)
           (str/join)
           (str "#"))
      hex-code)))

(defn hex-to-rgb
  "Converts a hexadecimal color to RGB color"
  [hex-code]
  (let [hex (partition 2 (rest (handle-short-hex hex-code)))
        r (first hex)
        g (second hex)
        b (last hex)]
    (mapv #(-> (conj % "0x") 
               (str/join) 
               (c/read-string)) 
          [r g b])))

(defn decimal-to-hex
  "Converts a decimal number to hex code"
  [decimal]
  (let [hex (-> decimal
                (* 255)
                (Math/round)
                (.toString 16))]
    (if (= 1 (count hex))
      (str "0" hex)
      hex)))

(defn hex-to-decimal
  "Converts hex code to a decimal number"
  [hex]
  (let [decimal (-> (c/read-string (str "0x" hex))
                    (/ 255)
                    (round-number))]
    decimal))

(defn rgb-to-hex
  "Converts an RGB code to a hex code"
  [rgb-code]
  (->> rgb-code
       (map #(.toString % 16))
       (map #(if (= (count %) 1) (str "0" %) %))
       (str/join)
       (str "#")))

(defn rgb-format-css
  "Formats rgb output in CSS rgb() form"
  [rgb-code]
  (str "rgb(" (str/join ", " rgb-code) ")"))

(defn rgb-unformat-css
  "Formats CSS rgb() as data"
  [css-code]
  (-> css-code
      (str/replace #"rgb" "")
      c/read-string
      vec))

(defn rgba-format-css
  "Formats rgb output in CSS rgb() form"
  [rgba-code]
  (str "rgba(" (str/join ", " rgba-code) ")"))

(defn rgba-unformat-css
  "Formats CSS rgba() as data"
  [css-code]
  (-> css-code
      (str/replace #"rgba" "")
      c/read-string
      vec))

(defn rgba-to-hex8
  "Converts an RGBA code to a hex8 code"
  [rgba-code]
  (let [colors (drop-last rgba-code)
        opacity (last rgba-code)
        hex-colors (->> colors
                        (map #(.toString % 16))
                        (map #(if (= (count %) 1) (str "0" %) %))
                        (str/join)
                        (str "#"))]
    (str hex-colors (decimal-to-hex opacity))))

(defn hex8-to-rgba
  "Converts a hex8 code to RGBA color"
  [hex-code]
  (let [hex (partition 2 (rest (handle-short-hex hex-code)))
        r (first hex)
        g (second hex)
        b (nth hex 2)
        a (last hex)
        colors (mapv #(-> (conj % "0x") 
                         (str/join) 
                         (c/read-string)) 
                    [r g b])]
    (conj colors (hex-to-decimal (str/join a)))))

(comment
  (c/read-string "0xff")
  ; 255
  )
