(ns calculators.views
  (:require 
    [calculators.views.pixel :as px]
    [calculators.views.percentage :as pe]
    [calculators.views.color :as co]))

(defn pixel-to-rem-calculator [] 
  [:<>
   [:h2.text-xl.mt-6.mx-6 "Pixel / Rem"]
   [px/rem-to-pixel-form]])

(defn percentage-calculator [] 
  [:<>
   [:h2.text-xl.mt-6.mx-6 "Percentage"]
   [pe/percentage-as-number-form]
   [pe/number-as-percentage-form]
   [pe/percengate-change-form]])

(defn color-calculator []
  [:div {:class "mb-14"}
   [:h2 {:class "text-xl mt-6 mx-6"} "Color"]
   [:h3 {:class "text-lg mt-6 mx-6"} "Hex to RGB"]
   [:div {:class "space-x-16 bg-gray-50 w-full flex"}
    [co/hex-to-rgb-form]
    [co/hex8-to-rgba-form]]])
