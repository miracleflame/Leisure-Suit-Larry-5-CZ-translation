;;; Sierra Script 1.0 - (do not remove this comment)
(script# 16)
(include sci.sh)
(use Main)
(use n012)
(use Obj)

(public
	ll5InitCode 0
)

(instance ll5InitCode of Code
	(properties)
	
	(method (init &tmp temp0)
		(= gWindow (ScriptID 0 21))
		(proc12_0)
		(= global34 1)
		(= global79 30)
		(StrCpy @global42 {})
		(gGame
			egoMoveSpeed: 6
			setCursor: gCursorNumber 1 304 172
			detailLevel: 5
		)
		(= global21 997)
		(= global16 1000)
		(= global22 2107)
		(= global26 2108)
		(= global23 1207)
		(= global173 2407)
		(= global174 4115)
		(= global175 2510)
		(= global155 12)
		(= global106 (DoSound sndDISPOSE))
		(if
			(and
				(>= (= global105 (Graph grGET_COLOURS)) 2)
				(<= global105 16)
			)
			(proc0_8 0)
		else
			(proc0_7 0)
		)
		(gWindow color: 0 back: global147)
		((ScriptID 19 1)
			color: 0
			back: global147
			topBordColor: global147
			lftBordColor: global147
			rgtBordColor: global147
			botBordColor: global147
			insideColor: global139
			topBordColor2: global143
			lftBordColor2: global143
			botBordColor2: gLowlightColor
			rgtBordColor2: gLowlightColor
		)
		((ScriptID 0 20) color: 0 back: global147)
		((ScriptID 19 0) init:)
		(UnLoad 130 12)
	)
)
