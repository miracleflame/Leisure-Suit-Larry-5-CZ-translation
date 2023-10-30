;;; Sierra Script 1.0 - (do not remove this comment)
(script# 258)
(include sci.sh)
(use Main)
(use LLRoom)
(use CueObj)
(use Cycle)
(use InvI)
(use User)
(use PicView)

(public
	rm258 0
)

(local
	local0
	local1
	local2
	local3
	[local4 4]
	[local8 4]
	[local12 4]
	local16
	[local17 10]
	[local27 8] = [9 0 3 9 2 1 9 9]
	[local35 16] = [900 16053 1010 12415 1120 -31513 1240 -29008 130 -1897 220 14065 340 -5944 440 -9748]
	[local51 16] = [920 -21641 1030 -7348 1150 23802 1200 -3371 100 -15834 210 -2231 310 26084 410 -22485]
	[local67 16] = [950 18734 1050 -9228 1140 -25374 1230 -28538 120 -27849 240 31525 330 -2964 430 29519]
	[local83 16] = [930 -7324 1040 -18826 1110 12320 1250 -24920 140 -7872 230 -27867 320 -25448 400 -20441]
)
(procedure (localproc_032a param1 param2 &tmp temp0 temp1 [temp2 10])
	(= temp0 (* (Random 0 7) 2))
	(switch param2
		(1
			(= [local8 param1] [local83 temp0])
			(= [local4 param1] [local83 (+ temp0 1)])
		)
		(2
			(= [local8 param1] [local67 temp0])
			(= [local4 param1] [local67 (+ temp0 1)])
		)
		(4
			(= [local8 param1] [local51 temp0])
			(= [local4 param1] [local51 (+ temp0 1)])
		)
		(5
			(= [local8 param1] [local35 temp0])
			(= [local4 param1] [local35 (+ temp0 1)])
		)
	)
	(if
	(or (< [local8 param1] 900) (>= [local8 param1] 1200))
		(StrCpy @temp2 {PM})
	else
		(StrCpy @temp2 {AM})
	)
	(Format
		@local17
		258
		3
		(/ [local8 param1] 100)
		(mod [local8 param1] 100)
		@temp2
	)
)

(instance rm258 of LLRoom
	(properties
		picture 258
	)
	
	(method (init)
		(super init:)
		(cond 
			((proc0_6 46) (card y: 97) (boardPass init:) (proc0_22 1) (proc0_3))
			((and (proc0_6 8) (not (gLarry has: 8)))
				(proc0_22 1)
				(slot init:)
				(dispenser init:)
				(if (not (gLarry has: 7)) (slot doVerb: 4 7))
			)
			(else
				(proc0_2)
				(Display
					{V tuto chvíli nejsou k dispozici palubní lístky. Zkuste to prosím znovu v jiném mìstì!}
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
				(if (not (gLarry has: 7)) (gLarry get: 7))
				(proc0_17 15 2 global2)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if local1
			(pEvent claimed: 1)
			(card init:)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb param2)
		(return
			(switch theVerb
				(2 (proc0_14 258 0))
				(4
					(if (== param2 7)
						(proc0_14 258 1)
					else
						(super doVerb: theVerb param2 &rest)
					)
				)
				(1
					(if (== ((gIconBar at: 0) cursor?) 6)
						(cond 
							((or (proc0_6 46) (gLarry has: 7)) (global2 newRoom: 250))
							((gCast contains: card)
								(global2 drawPic: (global2 picture?))
								(switch (++ local3)
									(1
										(Display
											{Hej! Vezmìte si zlatou kartu AeroDork!}
											dsCOORD
											144
											75
											dsCOLOR
											global128
											dsWIDTH
											110
											dsFONT
											global23
										)
									)
									(2
										(Display
											{Podívej, ty blbeèku. Jestli se zatouláš a necháš tu kartu tady, postarám se, aby tvoje zavazadla letìla bez mezipøistání do Muncie v Indianì!}
											dsCOORD
											144
											75
											dsCOLOR
											global128
											dsWIDTH
											110
											dsFONT
											global23
										)
									)
									(else 
										(Display
											{Fajn. Ignoruju tì.}
											dsCOORD
											144
											75
											dsCOLOR
											global128
											dsWIDTH
											110
											dsFONT
											global23
										)
									)
								)
							)
							(else
								(bar1 dispose:)
								(bar2 dispose:)
								(bar3 dispose:)
								(card init:)
							)
						)
					else
						(return 0)
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
	
	(method (cue)
		(self newRoom: 250)
	)
	
	(method (newRoom)
		(if (gCast contains: card)
			(proc0_14 258 2)
		else
			(proc0_22 0)
			(super newRoom: &rest)
		)
	)
	
	(method (notify param1 &tmp [temp0 4])
		(switch param1
			(-1 (card init:))
			(-2
				(= local2 1)
				(boardPass init:)
			)
			([local4 local16]
				(boardPass init:)
			)
			(else 
				(= local1 1)
				(global2 drawPic: (global2 picture?))
				(Display
					{Zadali jste nesprávnou destinaci pro toto letištì v tuto hodinu. Ale i tak si vážíme toho, že jste si vybrali AeroDork Airlines.}
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
			)
		)
	)
)

(instance boardPass of Actor
	(properties
		x 164
		y 158
		description {palubní lístek}
		view 258
		loop 1
	)
	
	(method (init)
		(super init:)
		(proc0_2)
		(global2 drawPic: (global2 picture?) 100)
		(if local2
			(Display
				{Aha, to jste vy, pane Hughesi! Samozøejmì, že mùžete mít palubní lístek! Hned to bude, pane!}
				dsCOORD
				144
				75
				dsCOLOR
				global128
				dsWIDTH
				110
				dsFONT
				global23
			)
		else
			(Display
				{Prosím, vezmìte si palubní vstupenku.}
				dsCOORD
				144
				75
				dsCOLOR
				global128
				dsWIDTH
				110
				dsFONT
				global23
			)
		)
		(if (not (proc0_7 46))
			(gLongSong2 number: 257 setLoop: 0 play:)
			(self setPri: 3 setMotion: MoveTo x 178 self)
		else
			(self posn: 164 178 setCel: 255 setPri: 13)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 258 4))
			(3
				(proc0_10 4)
				(gLarry get: 8)
				(card init:)
				(proc0_8 46)
				(self dispose:)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(gLongSong2 stop:)
		(if (not cel)
			(self setPri: -1 setCycle: End self)
		else
			((Inv at: 8) state: [local27 [local12 local16]])
			(= global177 (+ (* (Random 2 10) 100) (Random 65 70)))
			(proc0_3)
		)
	)
)

(instance card of Actor
	(properties
		x 83
		y 107
		description {tvoje karta AeroDork}
		view 258
		priority 3
		signal $0010
		moveSpeed 10
	)
	
	(method (init)
		(super init:)
		(if (== y 97)
			(global2 drawPic: (global2 picture?) 100)
			(Display
				{Prosím, vezmìte si svou zlatou kartu AeroDork.}
				dsCOORD
				144
				75
				dsCOLOR
				global128
				dsWIDTH
				110
				dsFONT
				global23
			)
			(gLongSong2 number: 258 setLoop: 0 play:)
			(self setMotion: MoveTo x 107)
		else
			(proc0_17 10 1 self)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 258 5))
			(3
				(proc0_2)
				(global2 drawPic: (global2 picture?) 100)
				(Display
					{Dìkujeme, že letíte s AeroDork!}
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
				(gLarry get: 7)
				(proc0_17 5 0 global2)
				(self dispose:)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue &tmp temp0)
		(switch (++ local0)
			(1
				(gLongSong2 number: 258 setLoop: 0 play:)
				(self setMotion: MoveTo x 97 self)
			)
			(2
				(User canInput: 1)
				(gLarry put: 7)
				(= [local12 0] 0)
				(= [local12 1] 0)
				(= [local12 2] 0)
				(Display
					{Vítejte, Cliffe Taurusi! Kam dnes?}
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
				(= temp0 0)
				(if (not (proc0_6 9))
					(localproc_032a temp0 5)
					(Display
						{New York}
						dsCOORD
						144
						102
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@local17
						dsCOORD
						215
						102
						dsCOLOR
						global128
						dsWIDTH
						105
						dsFONT
						global23
					)
					(= [local12 temp0] 5)
					(++ temp0)
				)
				(if (not (proc0_6 10))
					(localproc_032a temp0 4)
					(Display
						{Atlantic City}
						dsCOORD
						144
						(+ 102 (* 10 temp0))
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@local17
						dsCOORD
						215
						(+ 102 (* 10 temp0))
						dsCOLOR
						global128
						dsWIDTH
						105
						dsFONT
						global23
					)
					(= [local12 temp0] 4)
					(++ temp0)
				)
				(if (not (proc0_6 11))
					(localproc_032a temp0 2)
					(Display
						{Miami}
						dsCOORD
						144
						(+ 102 (* 10 temp0))
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@local17
						dsCOORD
						215
						(+ 102 (* 10 temp0))
						dsCOLOR
						global128
						dsWIDTH
						105
						dsFONT
						global23
					)
					(= [local12 temp0] 2)
					(++ temp0)
				)
				(if (not temp0)
					(localproc_032a temp0 1)
					(Display
						{Los Angeles}
						dsCOORD
						144
						102
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@local17
						dsCOORD
						210
						102
						dsCOLOR
						global128
						dsWIDTH
						100
						dsFONT
						global23
					)
					(= [local12 temp0] 1)
					(++ temp0)
				)
				(if temp0
					(bar1 init:)
					(if (> temp0 1)
						(bar2 init:)
						(if (> temp0 2) (bar3 init:))
					)
				)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: 2)
				(self dispose:)
			)
		)
	)
)

(instance slot of Feature
	(properties
		x 80
		y 19
		z -100
		nsTop 91
		nsLeft 63
		nsBottom 148
		nsRight 98
		description {štìrbina na kartu}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 258 6))
			(4
				(switch param2
					(7
						(User canInput: 0)
						(card init:)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance dispenser of Feature
	(properties
		x 162
		y 178
		nsTop 171
		nsLeft 120
		nsBottom 186
		nsRight 204
		description {štìrbina pro palubní lístek}
		sightAngle 40
		lookStr {Palubní lístky jsou emitovány z této štìrbiny.}
	)
)

(instance ATMName of Feature
	(properties
		x 164
		y 27
		nsTop 15
		nsLeft 57
		nsBottom 40
		nsRight 271
		description {štítek se jménem}
		sightAngle 40
		lookStr {Nápis na štítku zní: "AeroDork Airlines."}
	)
)

(instance screen of Feature
	(properties
		x 194
		y 110
		nsTop 63
		nsLeft 130
		nsBottom 157
		nsRight 259
		description {obrazovka}
		sightAngle 40
		lookStr {Bankomat AeroDork má dotykovou obrazovku.}
	)
)

(instance bar1 of Feature
	(properties
		x 174
		y 105
		nsTop 100
		nsLeft 143
		nsBottom 110
		nsRight 205
		description {cílová destinace}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 80])
		(switch theVerb
			(2
				(Format
					@temp0
					258
					7
					(switch [local12 0]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(proc0_14 @temp0)
			)
			(3
				(= local16 0)
				(global2 drawPic: (global2 picture?) 100)
				(Display
					258
					8
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
				(proc0_14 258 9 80 {Nápovìda od Ala Lowa})
				((ScriptID 20 0) init: 0)
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance bar2 of Feature
	(properties
		x 174
		y 115
		nsTop 110
		nsLeft 143
		nsBottom 120
		nsRight 205
		description {cílová destinace}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2 param3 &tmp [temp0 80])
		(asm
			lsp      theVerb
			dup     
			ldi      2
			eq?     
			bnt      code_0c35
			pushi    4
			lea      @temp0
			push    
			pushi    258
			pushi    7
			ldi      1
			lsli     local12
			dup     
			eq?     
			bnt      code_0c01
			lofsa    {Los Angeles}
			jmp      code_0c25
code_0c01:
			dup     
			ldi      2
			eq?     
			bnt      code_0c0e
			lofsa    {Miami}
			jmp      code_0c25
code_0c0e:
			dup     
			ldi      4
			eq?     
			bnt      code_0c1b
			lofsa    {Atlantic City}
			jmp      code_0c25
code_0c1b:
			dup     
			ldi      5
			eq?     
			bnt      code_0c25
			lofsa    {New York}
code_0c25:
			toss    
			push    
			callk    Format,  8
			pushi    1
			lea      @temp0
			push    
			callb    proc0_14,  2
			jmp      code_0cb5
code_0c35:
			dup     
			ldi      3
			eq?     
			bnt      code_0ca8
			ldi      1
			sal      local16
			pushi    #drawPic
			pushi    2
			pushi    #picture
			pushi    0
			lag      global2
			send     4
			push    
			pushi    100
			lag      global2
			send     8
			pushi    11
			pushi    258
			pushi    8
			pushi    100
			pushi    144
			pushi    75
			pushi    102
			lsg      global128
			pushi    106
			pushi    110
			pushi    105
			lsg      global23
			callk    Display,  22
			pushi    4
			pushi    258
			pushi    9
			pushi    80
			lofsa    {Nápovìda od Ala Lowa}
			push    
			callb    proc0_14,  8
			pushi    #init
			pushi    1
			pushi    0
			pushi    2
			pushi    20
			pushi    0
			callk    ScriptID,  4
			send     6
			pushi    #dispose
			pushi    0
			lofsa    bar1
			send     4
			pushi    #dispose
			pushi    0
			lofsa    bar2
			send     4
			pushi    #dispose
			pushi    0
			lofsa    bar3
			send     4
			jmp      code_0cb5
code_0ca8:
			pushi    #doVerb
			pushi    2
			lsp      theVerb
			lsp      param2
			&rest    param3
			super    Feature,  8
code_0cb5:
			toss    
			ret     
		)
	)
)

(instance bar3 of Feature
	(properties
		x 174
		y 125
		nsTop 120
		nsLeft 143
		nsBottom 130
		nsRight 205
		description {cílová destinace}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 80])
		(switch theVerb
			(2
				(Format
					@temp0
					258
					7
					(switch [local12 2]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(proc0_14 @temp0)
			)
			(3
				(= local16 2)
				(global2 drawPic: (global2 picture?) 100)
				(Display
					258
					10
					dsCOORD
					144
					75
					dsCOLOR
					global128
					dsWIDTH
					110
					dsFONT
					global23
				)
				(proc0_14 258 9 80 {Nápovìda od Ala Lowa})
				((ScriptID 20 0) init: 0)
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
