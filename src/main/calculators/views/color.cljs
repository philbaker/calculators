(ns calculators.views.color
  (:require [reagent.core :as r]
            [calculators.helpers.color :as co]))

(defn input-rgb-to-hex [hex rgb e]
  (let [val (-> e .-target .-value)]
    (try 
      (reset! rgb (co/rgb-format-css (co/hex-to-rgb val)))
      (catch js/Error e))
    (reset! hex val)))

(defn input-hex-to-rgb [hex rgb e]
  (let [val (-> e .-target .-value)]
    (try 
      (reset! hex (co/rgb-to-hex (co/rgb-unformat-css val)))
      (catch js/Error e))
    (reset! rgb val)))

(defn hex-to-rgb-form []
  (let [hex (r/atom "#000000")
        rgb (r/atom "rgb(0, 0, 0)")]
    (fn []
      [:div {:class "p-6 mt-4 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex"} "hex"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @hex
          :on-change #(input-rgb-to-hex hex rgb %)
          :id "hex",
          :name "hex",
          :placeholder "#000000",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgb"} "rgb"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @rgb
          :on-change #(input-hex-to-rgb hex rgb %)
          :placeholder "rgb(0,0,0)",
          :id "rgb",
          :name "rgb",
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @hex}}]]])))

(defn input-rgba-to-hex8 [hex8 rgba e]
  (let [val (-> e .-target .-value)]
    (try 
      (reset! rgba (co/rgba-format-css (co/hex8-to-rgba val)))
      (catch js/Error e))
    (reset! hex8 val)))

(defn input-hex8-to-rgba [hex8 rgba e]
  (let [val (-> e .-target .-value)]
    (try 
      (reset! hex8 (co/rgba-to-hex8 (co/rgba-unformat-css val)))
      (catch js/Error e))
    (reset! rgba val)))

(defn hex8-to-rgba-form []
  (let [hex8 (r/atom "#00000080")
        rgba (r/atom "rgb(0, 0, 0, 0.5)")]
    (fn []
      [:div {:class "p-6 mt-4 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex8"} "hex8"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @hex8
          :on-change #(input-rgba-to-hex8 hex8 rgba %)
          :id "hex8",
          :name "hex8",
          :placeholder "#000000",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgba"} "rgba"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @rgba
          :on-change #(input-hex8-to-rgba hex8 rgba %)
          :id "rgba",
          :name "rgba",
          :placeholder "rgba(0, 0, 0, 0.5)"
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @hex8}}]]])))
