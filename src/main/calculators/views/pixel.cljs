(ns calculators.views.pixel
  (:require [calculators.helpers.pixel :as px]
            [helix.core :refer [defnc <>]]
            [helix.hooks :as hooks]
            [helix.dom :as d]))

(defnc pixel []
  (let [[number set-number] (hooks/use-state 16)]
    (<>
      (d/label {:className "block text-sm font-medium leading-6 text-gray-900",
                :htmlFor "pixel"}
               "Pixel")
      (d/input {:className "block w-full sm:w-48 rounded-md border-0 p-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                :value number
                :on-change #(set-number (.. % -target -value))
                :id "pixel"
                :name "pixel"
                :placeholder "Enter number"
                :type "number"})
      (d/label {:className "mt-2 block text-sm font-medium leading-6 text-gray-900",
                :htmlFor "rem"}
               "Rem")
      (d/input {:className "block w-full sm:w-48 rounded-md border-0 p-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                :value (px/pixel-to-rem (js/Number number))
                :on-change #(set-number (px/rem-to-pixel (js/Number (.. % -target -value))))
                :id "rem"
                :name "rem"
                :placeholder "Enter number"
                :type "number"}))))

