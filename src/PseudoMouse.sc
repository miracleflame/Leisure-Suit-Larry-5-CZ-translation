;;; Sierra Script 1.0 - (do not remove this comment)
(script# 933)
(include sci.sh)
(use Main)
(use Obj)


(class PseudoMouse of Code
	(properties
		cursorInc 2
		minInc 2
		maxInc 20
		prevDir 0
		joyInc 5
	)
	
	(method (doit &tmp gPEventX_2 gPEventY_2)
		(= gPEventX_2 (gPEvent x?))
		(= gPEventY_2 (gPEvent y?))
		(switch prevDir
			(1
				(= gPEventY_2 (- gPEventY_2 cursorInc))
			)
			(2
				(= gPEventX_2 (+ gPEventX_2 cursorInc))
				(= gPEventY_2 (- gPEventY_2 cursorInc))
			)
			(3
				(= gPEventX_2 (+ gPEventX_2 cursorInc))
			)
			(4
				(= gPEventX_2 (+ gPEventX_2 cursorInc))
				(= gPEventY_2 (+ gPEventY_2 cursorInc))
			)
			(5
				(= gPEventY_2 (+ gPEventY_2 cursorInc))
			)
			(6
				(= gPEventX_2 (- gPEventX_2 cursorInc))
				(= gPEventY_2 (+ gPEventY_2 cursorInc))
			)
			(7
				(= gPEventX_2 (- gPEventX_2 cursorInc))
			)
			(8
				(= gPEventX_2 (- gPEventX_2 cursorInc))
				(= gPEventY_2 (- gPEventY_2 cursorInc))
			)
		)
		(gGame setCursor: gCursorNumber 1 gPEventX_2 gPEventY_2)
	)
	
	(method (handleEvent pEvent)
		(return
			(if
			(and (gUser canInput:) (& (pEvent type?) evJOYSTICK))
				(= prevDir
					(if
						(or
							(not gIconBar)
							(!= ((gIconBar curIcon?) message?) 1)
						)
						(= prevDir (pEvent message?))
					else
						(return (= prevDir (pEvent message?)))
					)
				)
				(= cursorInc
					(if (& (pEvent type?) evKEYBOARD)
						(if (& (pEvent modifiers?) emSHIFT) minInc else maxInc)
					else
						joyInc
					)
				)
				(cond 
					((& (pEvent type?) evKEYBOARD)
						(if prevDir
							(self doit:)
						else
							(pEvent claimed: 0)
							(return 0)
						)
					)
					(prevDir (self start:))
					(else (self stop:))
				)
				(return (pEvent claimed: 1))
			else
				0
			)
		)
	)
	
	(method (start thePrevDir)
		(if argc (= prevDir thePrevDir))
		(gTheDoits add: self)
	)
	
	(method (stop)
		(= prevDir 0)
		(gTheDoits delete: self)
	)
)
