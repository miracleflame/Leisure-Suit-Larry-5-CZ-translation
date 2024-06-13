;;; Sierra Script 1.0 - (do not remove this comment)
(script# 932)
(include sci.sh)
(use Main)
(use Class_255_0)

(public
	proc932_0 0
	proc932_1 1
	proc932_2 2
	proc932_3 3
	proc932_4 4
	proc932_5 5
	proc932_6 6
	proc932_7 7
)

(local
	theGGameSubtitleLang
	local1
)
(procedure (proc932_0)
	(localproc_003c 0 &rest)
)

(procedure (proc932_1)
	(localproc_003c 1 &rest)
)

(procedure (proc932_2 param1 param2 param3 param4)
	(return
		(cond 
			((== (gGame printLang?) 1)
				(if (or (< argc 3) (== (gGame subtitleLang?) 0))
					param1
				else
					param3
				)
			)
			((or (< argc 4) (== (gGame subtitleLang?) 0)) param2)
			(else param4)
		)
	)
)

(procedure (proc932_3 &tmp gGameSubtitleLang)
	(if
		(and
			(not theGGameSubtitleLang)
			(= gGameSubtitleLang (gGame subtitleLang?))
		)
		(= theGGameSubtitleLang gGameSubtitleLang)
		(gGame subtitleLang: 0)
	)
	(return gGameSubtitleLang)
)

(procedure (proc932_4 &tmp theTheGGameSubtitleLang)
	(if
		(and
			(= theTheGGameSubtitleLang theGGameSubtitleLang)
			(not (gGame subtitleLang?))
		)
		(gGame subtitleLang: theGGameSubtitleLang)
		(= theGGameSubtitleLang 0)
	)
	(return theTheGGameSubtitleLang)
)

(procedure (proc932_5 &tmp gGameSubtitleLang)
	(return
		(if (= gGameSubtitleLang (gGame subtitleLang?))
			(gGame subtitleLang: (gGame printLang?))
			(gGame printLang: gGameSubtitleLang)
			(return 1)
		else
			0
		)
	)
)

(procedure (proc932_6 param1 param2 param3 param4 &tmp gGamePrintLang gGameSubtitleLang temp2 [temp3 1000])
	(if (== argc 4)
		(GetFarText @temp3 param3 param4)
	else
		(StrCpy @temp3 param3)
	)
	(= gGamePrintLang (gGame printLang?))
	(= gGameSubtitleLang (gGame subtitleLang?))
	(gGame printLang: 1 subtitleLang: 0)
	(kernel_123 param1 @temp3 0)
	(if (= temp2 0)
		(gGame printLang: temp2)
		(kernel_123 param2 @temp3 0)
	else
		(StrCpy param2 {})
	)
	(gGame
		printLang: gGamePrintLang
		subtitleLang: gGameSubtitleLang
	)
	(return param1)
)

(procedure (proc932_7 param1 param2)
	(return (if (== (gGame parseLang?) 1) param1 else param2))
)

(procedure (localproc_003c param1 &tmp gGamePrintLang gGameSubtitleLang)
	(= gGameSubtitleLang (gGame subtitleLang?))
	(gGame subtitleLang: 0)
	(if param1 (Display &rest) else (proc255_0 &rest 121))
	(if gGameSubtitleLang
		(= gGamePrintLang (gGame printLang?))
		(gGame printLang: gGameSubtitleLang)
		(if param1 (Display &rest) else (proc255_0 &rest))
		(gGame printLang: gGamePrintLang)
	)
	(gGame subtitleLang: gGameSubtitleLang)
)
