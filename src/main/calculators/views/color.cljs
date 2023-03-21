(ns calculators.views.color
  (:require [reagent.core :as r]
            [reagent.ratom :as rv :refer-macros [reaction]]
            [calculators.helpers.color :as co]))

(defn hex-to-rgb-form []
  (let [hex (r/atom "#000000")]
    (fn []
      [:div {:class "p-6 mt-4 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex"} "hex"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @hex
          :on-change #(reset! hex (-> % .-target .-value))
          :id "hex",
          :name "hex",
          :placeholder "#000000",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgb"} "rgb"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value (if (or (= (count @hex) 4) 
                         (= (count @hex) 7))
                   (try 
                     (co/rgb-format-css (co/hex-to-rgb @hex))
                     (catch js/Error e ""))
                   "")
          :id "rgb",
          :name "rgb",
          :readOnly "readonly"
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @hex}}]]])))

(defn rgb-to-hex-form []
  (let [rgb (r/atom "rgb(0, 0, 0)")]
    (fn []
      [:div {:class "p-6 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgb"} "rgb"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @rgb
          :on-change #(reset! rgb (-> % .-target .-value))
          :id "rgb",
          :name "rgb",
          :placeholder "rgb(0, 0, 0)",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex"} "hex"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value (try 
                     (co/rgb-to-hex (co/rgb-unformat-css @rgb))
                     (catch js/Error e ""))
          :id "hex",
          :name "hex",
          :readOnly "readonly"
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @rgb}}]]])))

(defn hex8-to-rgba-form []
  (let [hex8 (r/atom "#00000080")]
    (fn []
      [:div {:class "p-6 mt-4 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex8"} "hex8"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @hex8
          :on-change #(reset! hex8 (-> % .-target .-value))
          :id "hex8",
          :name "hex8",
          :placeholder "#000000",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgba"} "rgba"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value (try 
                     (co/rgba-format-css (co/hex8-to-rgba @hex8))
                     (catch js/Error e ""))
          :id "rgba",
          :name "rgba",
          :readOnly "readonly"
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @hex8}}]]])))


(defn rgba-to-hex8-form []
  (let [rgba (r/atom "rgba(0, 0, 0, 0.5)")]
    (fn []
      [:div {:class "p-6 flex items-start"} 
       [:div
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "rgba"} "rgba"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value @rgba
          :on-change #(reset! rgba (-> % .-target .-value))
          :id "rgba",
          :name "rgba",
          :placeholder "rgba(0, 0, 0)",
          :type "text"}]
        [:label
         {:class "mt-4 block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "hex8"} "hex8"]
        [:input
         {:class "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
          :value (try 
                     (co/rgba-to-hex8 (co/rgba-unformat-css @rgba))
                     (catch js/Error e ""))
          :id "hex8",
          :name "hex8",
          :readOnly "readonly"
          :type "text"}]]
       [:div {:class "ml-6"}
        [:div {:class "mt-8 w-24 h-24 border"
               :style {:backgroundColor @rgba}}]]])))
