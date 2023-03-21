(ns calculators.views.pixel
  (:require [reagent.core :as r] 
            [calculators.helpers.pixel :as px]))

(defn rem-to-pixel-form []
  (let [val (r/atom 16)]
    (fn []
      [:div {:class "p-6 mt-6 flex space-x-4 bg-gray-50"}
       [:div {:class "w-32"}
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "pixel"} "Pixel"]
        [:input
         {:class "block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @val
          :on-change #(reset! val (-> % .-target .-value))
          :id "pixel",
          :name "pixel",
          :placeholder "0",
          :type "number"}]]
       [:div {:class "w-32"}
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rem-to-pixel"} "Rem"]
        [:input
         {:class "block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value (px/pixel-to-rem (js/Number @val))
          :on-change #(reset! val (px/rem-to-pixel (js/Number (-> % .-target .-value))))
          :id "rem-to-pixel",
          :name "rem-to-pixel",
          :placeholder "0",
          :step "0.1"
          :type "number"}]]])))
