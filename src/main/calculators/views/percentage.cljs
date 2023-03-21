(ns calculators.views.percentage
  (:require [reagent.core :as r]
            [calculators.helpers.percentage :as pe]))

(defn percentage-as-number-form []
  (let [first (r/atom 5)
        second (r/atom 10)]
    (fn []
      [:div {:class "p-6 mt-6 flex items-end bg-gray-50"} 
       [:div {:class "flex items-center space-x-2"}
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "what-is"} "What is"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @first
           :on-change #(reset! first (-> % .-target .-value))
           :id "what-is",
           :name "what-is",
           :placeholder "0",
           :type "number"}]]]
       [:div {:class "ml-2 flex items-center space-x-2"} 
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "percent-of"} "% of"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @second
           :on-change #(reset! second (-> % .-target .-value))
           :id "percent-of",
           :name "percent-of",
           :placeholder "0",
           :type "number"}]]]
       [:input
        {:class "ml-6 w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
         :value (pe/percentage-as-number 
                  (js/Number @first) 
                  (js/Number @second))
         :readOnly "readonly"
         :type "number"}]])))

(defn number-as-percentage-form []
  (let [first (r/atom 5)
        second (r/atom 10)]
    (fn []
      [:div {:class "px-6 mt-6 flex items-end"} 
       [:div {:class "flex items-center space-x-2"}
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "the-number"} "The number"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @first
           :on-change #(reset! first (-> % .-target .-value))
           :id "the-number",
           :name "the-number",
           :placeholder "0",
           :type "number"}]]]
       [:div {:class "ml-2 flex items-center space-x-2"} 
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "percent-of"} "is what % of"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @second
           :on-change #(reset! second (-> % .-target .-value))
           :id "percent-of",
           :name "percent-of",
           :placeholder "0",
           :type "number"}]]]
       [:input
        {:class "ml-6 w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
         :value (pe/number-as-percentage
                  (js/Number @first) 
                  (js/Number @second))
         :readOnly "readonly"
         :type "number"}]])))

(defn percengate-change-form []
  (let [first (r/atom 5)
        second (r/atom 10)]
    (fn []
      [:div {:class "p-6 mt-6 flex items-end bg-gray-50"} 
       [:div {:class "flex items-center space-x-2"}
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "increase-decrease"} "% increase/decrease from"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @first
           :on-change #(reset! first (-> % .-target .-value))
           :id "increase-decrease",
           :name "increase-decrease",
           :placeholder "0",
           :type "number"}]]]
       [:div {:class "ml-2 flex items-center space-x-2"} 
        [:label
         {:class "block text-sm font-medium leading-6 text-gray-900",
          :htmlFor "to"} "to"]
        [:div
         [:input
          {:class "w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
           :value @second
           :on-change #(reset! second (-> % .-target .-value))
           :id "to",
           :name "to",
           :placeholder "0",
           :type "number"}]]]
       [:input
        {:class "ml-6 w-20 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
         :value (pe/percentage-change
                  (js/Number @first) 
                  (js/Number @second))
         :readOnly "readonly"
         :type "number"}]])))
