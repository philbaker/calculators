(ns calculators.core
  (:require [calculators.views.pixel :refer [pixel]]
            [calculators.views.percentage :as pe]
            [calculators.views.color :as co]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            ["react-dom/client" :as rdom]
            ["react-router-dom" :refer [BrowserRouter Route Routes NavLink]]))

(defnc header []
  (d/h1 {:className "text-2xl mt-6 mb-3"} 
        "Calculators"))

(defnc percentage-view []
  (d/div {:className "space-y-8"}
         ($ pe/percentage-as-number-form)
         ($ pe/number-as-percentage-form)
         ($ pe/percentage-change-form)))

(defnc color-view []
  (d/div {:className "space-y-8"}
         ($ co/hex-to-rgb-form)
         ($ co/hex8-to-rgba-form)))

(defnc app []
  (d/div {:className "px-6"}
    ($ BrowserRouter
       ($ header)
       (d/nav {:className "space-x-4 mt-3 mb-6"}
              ($ NavLink {:to "/" 
                          :relative "path" 
                          ; :className #(when (.-isActive %) "active")
                          :className "text-blue-800 hover:underline"} 
                 "Pixel")
              ($ NavLink {:to "/percentage" 
                          :relative "path" 
                          :className "text-blue-800 hover:underline"} 
                 "Percentage")
              ($ NavLink {:to "/color" 
                          :relative "path" 
                          :className "text-blue-800 hover:underline"} 
                 "Colour"))
       ($ Routes
          ($ Route {:path "/" :element [($ pixel {:key 1})]})
          ($ Route {:path "/percentage" :element [($ percentage-view {:key 2})]})
          ($ Route {:path "/color" :element [($ color-view {:key 3})]})))))

(defonce root (rdom/createRoot (js/document.getElementById "app")))
(defn ^:dev/after-load start []
  (.render root ($ app)))

(defn ^:export main []
  (start))
