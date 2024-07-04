;;; Sierra Script 1.0 - (do not remove this comment)
;;;(script# 258)
;;;(include sci.sh)
;;;(use Main)
;;;(use LLRoom)
;;;(use CueObj)
;;;(use Cycle)
;;;(use InvI)
;;;(use User)
;;;(use PicView)
;;;
;;; Decompiled by sluicebox
(script# 258)
(include sci.sh)
(use Main)
(use LLRoom) ;(use eRS)
(use CueObj) ;(use Feature)
(use Cycle) ;(use Motion)
(use InvI) ;(use Inventory)
(use User)
(use PicView) ;(use Actor)

(public
	rm258 0
)

(local
	cueCounter
	wrongNumber
	weCheated
	warnCounter
	[cpCode 4]
	[cpTime 4]
	[dest 4]
	theBar
	[departTime 10]
	[cityToState 8] = [9 0 3 9 2 1 9 9]
	[NYcopyProtCode 16] = [900 16053 1010 12415 1120 -31513 1240 -29008 130 -1897 220 14065 340 -5944 440 -9748]
	[ACcopyProtCode 16] = [920 -21641 1030 -7348 1150 23802 1200 -3371 100 -15834 210 -2231 310 26084 410 -22485]
	[McopyProtCode 16] = [950 18734 1050 -9228 1140 -25374 1230 -28538 120 -27849 240 31525 330 -2964 430 29519]
	[LAcopyProtCode 16] = [930 -7324 1040 -18826 1110 12320 1250 -24920 140 -7872 230 -27867 320 -25448 400 -20441]
)

(procedure (FormatTime which theCity &tmp i theTime [str 10])
	(= i (* (Random 0 7) 2))
	(switch theCity
		(1
			(= [cpTime which] [LAcopyProtCode i])
			(= [cpCode which] [LAcopyProtCode (+ i 1)])
		)
		(2
			(= [cpTime which] [McopyProtCode i])
			(= [cpCode which] [McopyProtCode (+ i 1)])
		)
		(4
			(= [cpTime which] [ACcopyProtCode i])
			(= [cpCode which] [ACcopyProtCode (+ i 1)])
		)
		(5
			(= [cpTime which] [NYcopyProtCode i])
			(= [cpCode which] [NYcopyProtCode (+ i 1)])
		)
	)
	(if (or (< [cpTime which] 900) (>= [cpTime which] 1200))
		(StrCpy @str {})
	else
		(StrCpy @str {})
	)
	(Format ; "%2d:%02d %s"
		@departTime
		258
		3
		(/ [cpTime which] 100)
		(mod [cpTime which] 100)
		@str
	)
)

(instance rm258 of LLRoom
	(properties
		picture 258
	)

	(method (init)
		(super init:)
		(cond
			((proc0_6 46) ; fPrintedPass
				(card y: 97)
				(boardPass init:)
				(proc0_22 1)
				(proc0_3)
			)
			((and (proc0_6 8) (not (gLarry has: 8))) ; fBeenToTown, Boarding_Pass
				(proc0_22 1)
				(slot init:)
				(dispenser init:)
				(if (not (gLarry has: 7)) ; AeroDork_Gold_Card
					(slot doVerb: 4 7)
				)
			)
			(else
				(proc0_2)
				(Display
					{V tuto chvíli nejsou k dispozici žádné palubní lístky. Zkuste to prosím znovu v jiném mìstì!}
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
				(if (not (gLarry has: 7)) ; AeroDork_Gold_Card
					(gLarry get: 7) ; AeroDork_Gold_Card
				)
				(proc0_17 15 2 global2)
			)
		)
	)

	(method (notify theNumber &tmp [temp0 4])
		(switch theNumber
			(-1
				(card init:)
			)
			(-2
				(= weCheated 1)
				(boardPass init:)
			)
			([cpCode theBar]
				(boardPass init:)
			)
			(else
				(= wrongNumber 1)
				(global2 drawPic: (global2 picture:))
				(Display
					{Zadali jste nesprávnou destinaci pro toto letištì v tuto hodinu. Ale i tak si vážíme toho, že jste si vybrali AeroBlb Airlines.}
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

	(method (handleEvent event)
		(if wrongNumber
			(event claimed: 1)
			(card init:)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(proc0_14 258 0) ; "You are standing before one of AeroDork Airline's amazing new Automatic Ticket Machines. Just insert your exclusive AeroDork Gold Club membership card into the slot on the left."
			)
			(4 ; Inventory
				(if (== invItem 7) ; AeroDork_Gold_Card
					(proc0_14 258 1) ; "Insert your exclusive AeroDork Gold Club membership card into the slot on the left."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(1 ; Walk
				(if (== ((gIconBar at: 0) cursor:) 6)
					(cond
						((or (proc0_6 46) (gLarry has: 7)) ; fPrintedPass, AeroDork_Gold_Card
							(global2 newRoom: 250)
						)
						((gCast contains: card)
							(global2 drawPic: (global2 picture:))
							(switch (++ warnCounter)
								(1
									(Display
										{Hej! Vezmìte si svou zlatou kartu AeroBlb!}
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
										{Hele, blbeèku. Jestli tu svou kartu necháš tady, zaøídím, aby tvoje kufry letìly bez mezipøistání do Muncie v Indianì!}
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

	(method (cue)
		(self newRoom: 250)
	)

	(method (newRoom)
		(if (gCast contains: card)
			(proc0_14 258 2) ; "Hey! Don't forget your gold card!"
		else
			(proc0_22 0)
			(super newRoom: &rest)
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
		(global2 drawPic: (global2 picture:) 100)
		(if weCheated
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
				{Prosím, vezmìte si palubní lístek.}
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
		(if (not (proc0_7 46)) ; fPrintedPass
			(gLongSong2 number: 257 setLoop: 0 play:)
			(self setPri: 3 setMotion: MoveTo x 178 self)
		else
			(self posn: 164 178 setCel: 255 setPri: 13)
		)
	)

	(method (cue)
		(gLongSong2 stop:)
		(if (not cel)
			(self setPri: -1 setCycle: End self)
		else
			((Inv at: 8) state: [cityToState [dest theBar]]) ; Boarding_Pass
			(= global177 (+ (* (Random 2 10) 100) (Random 65 70)))
			(proc0_3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(proc0_14 258 4) ; "Your newly obtained boarding pass is just hanging there, waiting for you to grab it."
			)
			(3 ; Do
				(proc0_10 4)
				(gLarry get: 8) ; Boarding_Pass
				(card init:)
				(proc0_8 46) ; fPrintedPass
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of Actor
	(properties
		x 83
		y 107
		description {tvoje karta AeroBlb}
		view 258
		priority 3
		signal 16
		moveSpeed 10
	)

	(method (init)
		(super init:)
		(if (== y 97)
			(global2 drawPic: (global2 picture:) 100)
			(Display
				{Prosím, vezmìte si svou zlatou kartu AeroBlb.}
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
			(2 ; Look
				(proc0_14 258 5) ; "Your AeroDork Gold Card is ready to return to your pocket."
			)
			(3 ; Do
				(proc0_2)
				(global2 drawPic: (global2 picture:) 100)
				(Display
					{Dìkujeme, že letíte s AeroBlb!}
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
				(gLarry get: 7) ; AeroDork_Gold_Card
				(proc0_17 5 0 global2)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp i)
		(switch (++ cueCounter)
			(1
				(gLongSong2 number: 258 setLoop: 0 play:)
				(self setMotion: MoveTo x 97 self)
			)
			(2
				(User canInput: 1)
				(gLarry put: 7) ; AeroDork_Gold_Card
				(= [dest 0] 0)
				(= [dest 1] 0)
				(= [dest 2] 0)
				(Display
					{Vítejte, Cliffe Taurusi! Kam to bude dnes?}
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
				(= i 0)
				(if (not (proc0_6 9)) ; fBeenInNewYork
					(FormatTime i 5)
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
						@departTime
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
					(= [dest i] 5)
					(++ i)
				)
				(if (not (proc0_6 10)) ; fBeenInAtlanticCity
					(FormatTime i 4)
					(Display
						{Atlantic City}
						dsCOORD
						144
						(+ 102 (* 10 i))
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@departTime
						dsCOORD
						215
						(+ 102 (* 10 i))
						dsCOLOR
						global128
						dsWIDTH
						105
						dsFONT
						global23
					)
					(= [dest i] 4)
					(++ i)
				)
				(if (not (proc0_6 11)) ; fBeenInMiami
					(FormatTime i 2)
					(Display
						{Miami}
						dsCOORD
						144
						(+ 102 (* 10 i))
						dsCOLOR
						global128
						dsWIDTH
						120
						dsFONT
						global23
					)
					(Display
						@departTime
						dsCOORD
						215
						(+ 102 (* 10 i))
						dsCOLOR
						global128
						dsWIDTH
						105
						dsFONT
						global23
					)
					(= [dest i] 2)
					(++ i)
				)
				(if (not i)
					(FormatTime i 1)
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
						@departTime
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
					(= [dest i] 1)
					(++ i)
				)
				(if i
					(bar1 init:)
					(if (> i 1)
						(bar2 init:)
						(if (> i 2)
							(bar3 init:)
						)
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
		description {otvor na kartu}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(proc0_14 258 6) ; "Insert your AeroDork Gold card into this slot."
			)
			(4 ; Inventory
				(switch invItem
					(7 ; AeroDork_Gold_Card
						(User canInput: 0)
						(card init:)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
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
		description {otvor na palubní lístek}
		sightAngle 40
		lookStr {Palubní lístky vycházejí z této štìrbiny.}
	)
)

(instance ATMName of Feature ; UNUSED
	(properties
		x 164
		y 27
		nsTop 15
		nsLeft 57
		nsBottom 40
		nsRight 271
		description {štítek se jménem}
		sightAngle 40
		lookStr {Nápis na štítku zní: "AeroBlb Airlines".}
	)
)

(instance screen of Feature ; UNUSED
	(properties
		x 194
		y 110
		nsTop 63
		nsLeft 130
		nsBottom 157
		nsRight 259
		description {obrazovka}
		sightAngle 40
		lookStr {Automat na lístky AeroBlb má dotykovou obrazovku.}
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

	(method (doVerb theVerb invItem &tmp [str 80])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					7
					(switch [dest 0]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(proc0_14 @str)
			)
			(3 ; Do
				(= theBar 0)
				(global2 drawPic: (global2 picture:) 100)
				(Display 258 8 dsCOORD 144 75 dsCOLOR global128 dsWIDTH 110 dsFONT global23) ; "Please enter the five-character Destination Code from your AeroDork Airline Travel Brochure."
				(proc0_14 258 9 80 {Nápovìda od Ala Lowa}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
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

	(method (doVerb theVerb invItem &tmp [str 80])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					7
					(switch [dest 1]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(proc0_14 @str)
			)
			(3 ; Do
				(= theBar 1)
				(global2 drawPic: (global2 picture:) 100)
				(Display 258 8 dsCOORD 144 75 dsCOLOR global128 dsWIDTH 110 dsFONT global23) ; "Please enter the five-character Destination Code from your AeroDork Airline Travel Brochure."
				(proc0_14 258 9 80 {Nápovìda od Ala Lowa}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
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

	(method (doVerb theVerb invItem &tmp [str 80])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					7
					(switch [dest 2]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(proc0_14 @str)
			)
			(3 ; Do
				(= theBar 2)
				(global2 drawPic: (global2 picture:) 100)
				(Display 258 10 dsCOORD 144 75 dsCOLOR global128 dsWIDTH 110 dsFONT global23) ; "Please enter the five character Destination Code from your AeroDork Airline Travel Brochure."
				(proc0_14 258 9 80 {Nápovìda od Ala Lowa}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)