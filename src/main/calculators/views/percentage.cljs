(ns calculators.views.percentage
  (:require [calculators.helpers.percentage :as pe]
            [helix.core :refer [defnc <>]]
            [helix.hooks :as hooks]
            [helix.dom :as d]))

(defnc percentage-as-number-form []
  (let [[state set-state] (hooks/use-state {:first 5 :second 10})]
    (d/div {:className "mt-6 sm:flex items-center space-y-2 sm:space-y-0 sm:space-x-3"}
           (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                     :htmlFor "what-is"} 
                    "What is")
           (d/input
             {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              :value (:first state)
              :on-change #(set-state assoc :first (.. % -target -value))
              :id "what-is",
              :name "what-is",
              :placeholder "0",
              :type "number"})
           (d/label
             {:className "block text-sm font-medium leading-6 text-gray-900",
              :htmlFor "percent-of"} 
             "% of")
           (d/input
             {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              :value (:second state)
              :on-change #(set-state assoc :second (.. % -target -value))
              :id "percent-of",
              :name "percent-of",
              :placeholder "0",
              :type "number"})
           (d/input
             {:className "mt-6 sm:mt-0 sm:ml-6 w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              :value (pe/percentage-as-number 
                       (js/Number (:first state)) 
                       (js/Number (:second state)))
              :readOnly "readonly"
              :type "number"}))))

(defnc number-as-percentage-form []
  (let [[state set-state] (hooks/use-state {:first 5 :second 10})]
    (d/div {:className "mt-6 sm:flex items-center space-y-2 sm:space-y-0 sm:space-x-3"}
           (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                     :htmlFor "the-number"} 
                    "The number")
           (d/input {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                     :value (:first state)
                     :on-change #(set-state assoc :first (.. % -target -value))
                     :id "the-number",
                     :name "the-number",
                     :placeholder "0",
                     :type "number"})
           (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                     :htmlFor "percent-of"} 
                    "is what % of") 
           (d/input {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                     :value (:second state)
                     :on-change #(set-state assoc (:second state) (.. % -target -value))
                     :id "percent-of",
                     :name "percent-of",
                     :placeholder "0",
                     :type "number"})
           (d/input {:className "mt-6 sm:mt-0 sm:ml-6 w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                     :value (pe/number-as-percentage
                              (js/Number (:first state)) 
                              (js/Number (:second state)))
                     :readOnly "readonly"
                     :type "number"}))))

(defnc percentage-change-form []
  (let [[state set-state] (hooks/use-state {:first 5 :second 10})] 
    (d/div {:className "mt-6 sm:flex items-center space-y-0 sm:space-y-2 sm:space-x-3"}
           (d/label
             {:className "block text-sm font-medium leading-6 text-gray-900",
              :htmlFor "increase-decrease"} "% increase/decrease from")
           (d/input
             {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              :value (:first state)
              :on-change #(set-state assoc :first (.. % -target -value))
              :id "increase-decrease",
              :name "increase-decrease",
              :placeholder "0",
              :type "number"})
           (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                     :htmlFor "to"} 
                    "to")
           (d/input {:className "w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                     :value (:second state)
                     :on-change #(set-state assoc :state (.. % -target -value))
                     :id "to",
                     :name "to",
                     :placeholder "0",
                     :type "number"})
           (d/input {:className "mt-6 sm:mt-0 sm:ml-6 w-full sm:w-20 block rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                     :value (pe/percentage-change
                              (js/Number (:first state)) 
                              (js/Number (:second state)))
                     :readOnly "readonly"
                     :type "number"}))))

