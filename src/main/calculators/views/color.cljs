(ns calculators.views.color
  (:require [helix.core :refer [defnc <>]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            [calculators.helpers.color :as co]))

(defnc hex-to-rgb-form []
  (let [[color set-color] (hooks/use-state {:hex "#000000" :rgb "rgb(0, 0, 0)"})]
    (d/div {:className "flex space-x-4"}
           (d/div
             (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                       :htmlFor "hex"} 
                      "hex")
             (d/input {:className "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                       :value (:hex color)
                       :on-change #(try
                                     (set-color assoc :rgb (co/rgb-format-css (co/hex-to-rgb (.. % -target -value))))
                                     (catch js/Error e)
                                     (finally (set-color assoc :hex (.. % -target -value)))) 
                       :id "hex",
                       :name "hex",
                       :placeholder "#000000",
                       :type "text"})
             (d/label {:className "mt-4 block text-sm font-medium leading-6 text-gray-900",
                       :htmlFor "rgb"} 
                      "rgb")
             (d/input {:className "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                       :value (:rgb color)
                       :on-change #(try
                                     (set-color assoc :hex (co/rgb-to-hex (co/rgb-unformat-css (.. % -target -value))))
                                     (catch js/Error e)
                                     (finally (set-color assoc :rgb (.. % -target -value)))) 
                       :placeholder "rgb(0,0,0)"
                       :id "rgb"
                       :name "rgb"
                       :type "text"}))
           (d/div {:className "mt-8 w-24 h-24 border"
                   :style {:backgroundColor (:hex color)}}))))

(defn hex8-to-rgba-form []
  (let [[color set-color] (hooks/use-state {:hex "#00000080" :rgb "rgba(0, 0, 0, 0.5)"})]
    (d/div {:className "flex space-x-4"}
           (d/div
             (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                       :htmlFor "hex8"} 
                      "hex8")
             (d/input
               {:className "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                :value (:hex color)
                :on-change #(try
                              (set-color assoc :rgb (co/rgba-format-css (co/hex8-to-rgba (.. % -target -value))))
                              (catch js/Error e)
                              (finally (set-color assoc :hex (.. % -target -value))))
                :id "hex8"
                :name "hex8"
                :placeholder "#000000"
                :type "text"})
             (d/label {:className "mt-4 block text-sm font-medium leading-6 text-gray-900",
                       :htmlFor "rgba"} "rgba")
             (d/input {:className "w-48 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                       :value (:rgb color)
                       :on-change #(try
                                     (set-color assoc :hex (co/rgba-to-hex8 (co/rgba-unformat-css (.. % -target -value))))
                                     (catch js/Error e)
                                     (finally (set-color assoc :rgb (.. % -target -value))))
                       :id "rgba",
                       :name "rgba",
                       :placeholder "rgba(0, 0, 0, 0.5)"
                       :type "text"}))
           (d/div {:className "mt-8 w-24 h-24 border"
                   :style {:backgroundColor (:hex color)}}))))
