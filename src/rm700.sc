;;; Sierra Script 1.0 - (do not remove this comment)
(script# 700)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use RTRandCycle)
(use Osc)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm700 0
)

(local
	local0
	theGCycleCnt
)
(instance rm700 of LLRoom
	(properties
		lookStr {Trampovo kasino je dokonalým příkladem architektonického stylu, jehož příkladem je Frank Lloyd Wrong.}
		picture 700
		north 710
		east 760
		south 780
	)
	
	(method (init)
		(proc958_0 132 710 622 255 194 191 192)
		(gLarry init: normalize: 553)
		(switch gGNumber
			(750
				(proc0_3)
				(gLarry posn: 117 164 setHeading: 180 edgeHit: 0)
				(proc0_7 49)
			)
			(north
				(proc0_3)
				(gLarry posn: 117 164 setHeading: 180 edgeHit: 0)
				(gLongSong fade: 80 10 10 0)
			)
			(south
				(self setScript: sFromSouth)
			)
			(east (gLarry y: 155))
			(200
				(proc0_2)
				(self setScript: sFromLimo)
			)
			(else 
				(self setScript: sFromLimo)
			)
		)
		(super init:)
		(doorman init: approachVerbs: 5)
		(if (!= gGNumber 750)
			(changeGirl init: approachVerbs: 5)
		)
		(trampSign init:)
		(leftLight init:)
		(rightLight init:)
		(slotSign init:)
		(bird init:)
		(leftNip init:)
		(rightNip init:)
		(centerNip init:)
		(leftRoller init: setCycle: Fwd setScript: sRoll)
		(middleRoller init: setCel: (Random 1 2) setCycle: Fwd)
		(rightRoller init: setCel: 3 setCycle: Fwd)
		(leftNeon init:)
		(rightNeon init:)
		(centerNeon init:)
		(dollars init:)
		(door init: approachVerbs: 3)
		(ass1 init:)
		(ass2 init:)
		(ass3 init:)
		(breasts1 init:)
		(breasts2 init:)
		(breasts3 init:)
		(girl1 init:)
		(girl2 init:)
		(girl3 init:)
		(burgerStand init:)
		(boardwalk init:)
		(beach init:)
		(trampSignF init:)
		(leftLightF init:)
		(rightLightF init:)
		(slotSignF init:)
		(leftNeonF init:)
		(rightNeonF init:)
		(centerNeonF init:)
		(dollarsF init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 221 176 231 172 319 172 319 189 298 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						98
						163
						84
						163
						84
						161
						3
						161
						3
						169
						173
						169
						197
						176
						216
						189
						0
						189
						0
						0
						319
						0
						319
						151
						253
						151
						253
						156
						228
						161
						147
						161
						143
						163
						135
						162
						121
						156
						121
						140
						115
						140
						115
						155
					yourself:
				)
		)
		(cond 
			((== gGNumber (global2 north?)) (gLongSong fade: 80 10 10 0))
			((!= gGNumber 200) (gLongSong number: 710 setLoop: -1 flags: 1 play: 80))
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(proc0_6 0)
				(> (Abs (- gCycleCnt theGCycleCnt)) 6)
			)
			(= theGCycleCnt gCycleCnt)
			(Palette 6 33 48 -1)
			(Palette 6 227 231 -1)
		)
		(cond 
			(script)
			((> (gLarry y?) 185) (proc0_2) (self setScript: sOcean))
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 710)
			(gLongSong fade: 127 10 10 0)
		else
			(gLongSong fade:)
		)
		(if (== script sOcean)
			0
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance sRoll of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= seconds (= seconds 5)))
			(1
				(leftRoller x: 96 y: 48 setLoop: 7)
				(middleRoller hide:)
				(rightRoller hide:)
				(= seconds (= seconds 5))
			)
			(2
				(leftRoller x: 99 y: 51 setLoop: 14)
				(middleRoller show:)
				(rightRoller show:)
				(self init:)
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gLarry posn: 320 220 setMotion: PolyPath 220 180 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sOcean of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gLarry setMotion: MoveTo 320 220 self)
			)
			(1 (global2 newRoom: 780))
		)
	)
)

(instance sFromLimo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (soundFX prevSignal?) 10)
				(== (soundFX number?) 194)
			)
			(soundFX prevSignal: 5)
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(limo init:)
				(gLarry hide:)
				(= ticks (= ticks 150))
			)
			(1
				(soundFX number: 191 play:)
				(= ticks (= ticks 50))
			)
			(2 (= ticks (= ticks 60)))
			(3
				(gLarry
					normalize: 553
					x: 107
					y: 177
					setLoop: 3
					show:
					setCel: 0
					setMotion: MoveTo 107 166 self
				)
			)
			(4
				(gLarry setLoop: -1 setHeading: 180 self)
			)
			(5 (= ticks (= ticks 60)))
			(6
				(soundFX number: 192 play:)
				(= ticks (= ticks 100))
			)
			(7
				(gLongSong number: 710 setLoop: -1 flags: 1 play: 80)
				(soundFX number: 194 play:)
			)
			(8
				(limo setStep: 1 1 setMotion: MoveTo 87 (limo y?) self)
			)
			(9
				(limo setStep: 3 3 setMotion: MoveTo 65 (limo y?) self)
			)
			(10
				(limo setStep: 4 4 setMotion: MoveTo 50 (limo y?) self)
			)
			(11
				(limo setStep: 5 5 setMotion: MoveTo 35 (limo y?) self)
			)
			(12
				(limo setStep: 6 6 setMotion: MoveTo -95 (limo y?) self)
			)
			(13
				(limo dispose:)
				(gLarry normalize: 553)
				(proc0_3)
				(= cycles (= cycles 1))
			)
			(14
				(self dispose:)
				(if
					(proc255_0
						700
						0
						81
						{Uložit}
						1
						81
						{Ne, proč se obtěžovat?}
						0
						80
						{AL říká}
						67
						-1
						20
					)
					(gGame save:)
				)
			)
		)
	)
)

(instance sLimo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (soundFX prevSignal?) 10)
				(== (soundFX number?) 194)
			)
			(soundFX prevSignal: 5)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp [temp0 110])
		(switch (= state (= state newState))
			(0
				(gLarry setHeading: 270)
				(doorman setLoop: 0 setCel: 0 setCycle: Osc 1 self)
			)
			(1
				(doorman setLoop: 1 setCel: 0)
				(soundFX number: 255 play: hold: 10)
				(limo
					posn: -100 178
					init:
					approachVerbs: 3
					setMotion: MoveTo 70 178 self
				)
			)
			(2
				(soundFX hold: -1)
				(gLarry setHeading: 90 self)
			)
			(3
				(switch global153
					(0
						(proc0_14 700 1)
						(doorman setLoop: 1 setCel: 0 setCycle: End self)
					)
					(1
						(proc0_14 700 2)
						(doorman setLoop: 2 setCel: 0 setCycle: Osc 1 self)
					)
					(else 
						(Format @temp0 700 3 global153)
						(proc0_14 @temp0)
						(doorman setLoop: 2 setCel: 0 setCycle: Osc 1 self)
					)
				)
			)
			(4
				(switch global153
					(0
						(proc0_18 Doorman 700 4 108 139 self)
					)
					(1
						(proc0_18 Doorman 700 5 108 139 self)
					)
					(else 
						(proc0_18 Doorman 700 6 108 139 self)
					)
				)
				(gLarry put: 17 0)
				(= global153 0)
			)
			(5
				(gLarry
					setMotion: PolyPath (limo approachX?) (limo approachY?) self
				)
			)
			(6
				(gLarry setHeading: 180 self)
			)
			(7 (= ticks (= ticks 60)))
			(8
				(soundFX number: 191 play:)
				(= ticks (= ticks 50))
			)
			(9
				(gLarry
					setLoop: 2
					setCycle: 0
					setPri: (gLarry priority?)
					setMotion: MoveTo (gLarry x?) (+ (gLarry y?) 6) self
				)
			)
			(10
				(gLarry x: 1000)
				(= ticks (= ticks 60))
			)
			(11
				(soundFX number: 192 play:)
				(= ticks (= ticks 50))
			)
			(12 (= ticks (= ticks 60)))
			(13 (soundFX number: 194 play:))
			(14
				(limo setStep: 3 3 setMotion: MoveTo 65 (limo y?) self)
			)
			(15
				(limo setStep: 4 4 setMotion: MoveTo 50 (limo y?) self)
			)
			(16
				(limo setStep: 5 5 setMotion: MoveTo 35 (limo y?) self)
			)
			(17
				(limo setStep: 6 6 setMotion: MoveTo -95 (limo y?) self)
			)
			(18 (global2 newRoom: 200))
		)
	)
)

(instance sGirlTalk of Script
	(properties)
	
	
(method (changeState newState &tmp temp0 temp1 [temp2 30])
		(switch (= state newState)
			(0
				(for
					((= temp0 0))
					(not (< 0 temp0 10000))
					((= temp0 (ReadNumber @temp2)))
					
					(= temp2 0)
					(proc255_2
						@temp2
						6
						{"Zadejte prosím číslo menší než 10000, ano?"}
						80
						{Cheri}
					)
				)
				(if (not (gLarry has: 17)) ; Silver_Dollar
					(proc0_18 Cheri 700 7 139 self) ; "Amazing! What a genius! What a coincidence! Congratulations, Sir! You have correctly guessed the number of which I have been thinking of. Here's your ten `Tramp Casino' lucky souvenir silver dollars."
				else
					(for
						((= temp1 temp0))
						(== temp0 temp1)
						((= temp1 (Random 1 6900)))
					)
					(Format @temp2 700 8 temp1) ; "Aw, too bad! I was thinking of %d."
					(proc0_18 Cheri @temp2 139 self)
				)
			)
			(1
				(if (gLarry has: 17) ; Silver_Dollar
					(proc0_18 Cheri 700 9 108 139 self) ; "But feel free to try again any time!"
				else
					(proc0_18 Cheri 700 10 108) ; "Please don't confuse them with REAL money!"
					(changeGirl setLoop: 1 setCel: 0 setCycle: Osc 1 self)
					(gLarry get: 17) ; Silver_Dollar
					(= global153 10)
				)
			)
			(2
				(changeGirl setLoop: 0)
				(self dispose:)
			)
		)
	)
;;;	(method (changeState newState &tmp temp0 temp1 [temp2 30])
;;;		(asm
;;;			lap      newState
;;;			aTop     state
;;;			push    
;;;			dup     
;;;			ldi      0
;;;			eq?     
;;;			bnt      code_0b96
;;;			ldi      0
;;;			sat      temp0
;;;code_0afe:
;;;			pushi    0
;;;			lat      temp0
;;;			lt?     
;;;			bnt      code_0b0a
;;;			pprev   
;;;			ldi      10000
;;;			lt?     
;;;code_0b0a:
;;;			not     
;;;			bnt      code_0b36
;;;			ldi      0
;;;			sat      temp2
;;;			pushi    5
;;;			lea      @temp2
;;;			push    
;;;			pushi    6
;;;			lofsa    {"Zadejte prosím číslo menší než 10000, ano?"}
;;;			push    
;;;			pushi    80
;;;			lofsa    {Cheri}
;;;			push    
;;;			calle    proc255_2,  10
;;;			pushi    1
;;;			lea      @temp2
;;;			push    
;;;			callk    ReadNumber,  2
;;;			sat      temp0
;;;			jmp      code_0afe
;;;code_0b36:
;;;			pushi    #has
;;;			pushi    1
;;;			pushi    17
;;;			lag      gLarry
;;;			send     6
;;;			not     
;;;			bnt      code_0b59
;;;			pushi    5
;;;			lofsa    Cheri
;;;			push    
;;;			pushi    700
;;;			pushi    7
;;;			pushi    139
;;;			pushSelf
;;;			callb    proc0_18,  10
;;;			jmp      code_0c17
;;;code_0b59:
;;;			lat      temp0
;;;			sat      temp1
;;;code_0b5d:
;;;			lst      temp0
;;;			lat      temp1
;;;			eq?     
;;;			bnt      code_0b72
;;;			pushi    2
;;;			pushi    1
;;;			pushi    6900
;;;			callk    Random,  4
;;;			sat      temp1
;;;			jmp      code_0b5d
;;;code_0b72:
;;;			pushi    4
;;;			lea      @temp2
;;;			push    
;;;			pushi    700
;;;			pushi    8
;;;			lst      temp1
;;;			callk    Format,  8
;;;			pushi    4
;;;			lofsa    Cheri
;;;			push    
;;;			lea      @temp2
;;;			push    
;;;			pushi    139
;;;			pushSelf
;;;			callb    proc0_18,  8
;;;			jmp      code_0c17
;;;code_0b96:
;;;			dup     
;;;			ldi      1
;;;			eq?     
;;;			bnt      code_0bff
;;;			pushi    #has
;;;			pushi    1
;;;			pushi    17
;;;			lag      gLarry
;;;			send     6
;;;			bnt      code_0bbf
;;;			pushi    6
;;;			lofsa    Cheri
;;;			push    
;;;			pushi    700
;;;			pushi    9
;;;			pushi    108
;;;			pushi    139
;;;			pushSelf
;;;			callb    proc0_18,  12
;;;			jmp      code_0c17
;;;code_0bbf:
;;;			pushi    4
;;;			lofsa    Cheri
;;;			push    
;;;			pushi    700
;;;			pushi    10
;;;			pushi    108
;;;			callb    proc0_18,  8
;;;			pushi    #setLoop
;;;			pushi    1
;;;			pushi    1
;;;			pushi    288
;;;			pushi    1
;;;			pushi    0
;;;			pushi    150
;;;			pushi    3
;;;			class    Osc
;;;			push    
;;;			pushi    1
;;;			pushSelf
;;;			lofsa    changeGirl
;;;			send     22
;;;			pushi    #get
;;;			pushi    1
;;;			pushi    17
;;;			lag      gLarry
;;;			send     6
;;;			ldi      10
;;;			sag      global153
;;;			jmp      code_0c17
;;;code_0bff:
;;;			dup     
;;;			ldi      2
;;;			eq?     
;;;			bnt      code_0c17
;;;			pushi    #setLoop
;;;			pushi    1
;;;			pushi    0
;;;			lofsa    changeGirl
;;;			send     6
;;;			pushi    #dispose
;;;			pushi    0
;;;			self     4
;;;code_0c17:
;;;			toss    
;;;			ret     
;;;		)
;;;	)
)

(instance bird of Actor
	(properties
		description {racek}
		lookStr {Osamělý racek létá sem a tam a hledá vhodný cíl - tebe!}
		yStep 5
		view 700
		loop 8
		priority 14
		signal $6810
		illegalBits $0000
		xStep 7
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd cue:)
	)
	
	(method (cue &tmp temp0 temp1)
		(= temp0 (- (Random 0 520) 100))
		(= temp1 (- (Random 0 150) 50))
		(self setMotion: MoveTo temp0 temp1 self)
	)
)

(instance limo of Actor
	(properties
		x 93
		y 180
		description {limuzína}
		approachX 80
		approachY 175
		lookStr {Tvá limuzína se vrátila. Nebo možná nějaká jí nápadně podobná!}
		view 700
		signal $4800
	)
)

(instance door of Door
	(properties
		x 118
		y 155
		description {přední dveře Trampova kasina}
		sightAngle 40
		approachX 120
		approachY 157
		lookStr {Nad dveřmi je malá bronzová deska s nápisem: "Těmito dveřmi prochází ti nejlepší lidé na světě - NAŠI CUCÁCI!"}
		view 251
		cycleSpeed 10
		entranceTo 710
		openSnd 622
		closeSnd 622
		moveToX 118
		moveToY 154
		enterType 0
		exitType 0
	)
)

(instance doorman of Prop
	(properties
		x 141
		y 162
		description {Pivovarník}
		sightAngle 40
		approachX 133
		approachY 165
		lookStr {Trampovo kasino promyšleně poskytuje vrátného, který uspokojí každou vaši cestovní potřebu - pokud ovšem potřebujete, aby vám přivolal limuzínu!}
		view 703
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (self doVerb: 5))
			(5
				(proc0_18 Doorman 700 11 108 139 self)
			)
			(10
				(proc0_18 Doorman 700 12 108)
			)
			(4
				(proc0_18 Doorman 700 13 108)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(if
			(proc255_0
				700
				14
				81
				{Ne, děkuji}
				0
				81
				{Ano, prosím}
				1
				80
				{Tvůj přátelský vrátný}
			)
			(proc0_2)
			(proc0_18 gLarry 700 15)
			(proc0_10 2 132)
			(proc0_18 Doorman 700 16 108)
			(global2 setScript: sLimo)
		else
			(proc0_18 gLarry 700 17)
		)
	)
)

(instance changeGirl of Prop
	(properties
		x 96
		y 162
		description {vstřícný pracovník kasina}
		sightAngle 40
		approachX 103
		approachY 164
		lookStr {Trampovo kasino zaměstnává krásnou mladou ženu, která vítá všechny jeho vzácné návštěvníky.}
		view 702
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 0)
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 32])
		(switch theVerb
			(3 (proc0_18 Cheri 700 18 108))
			(5
				(if (not local0)
					(proc0_18 Cheri 700 19 108)
					(= local0 1)
					(self approachVerbs: 5)
				else
					(proc0_10 2 131)
					(self setScript: sGirlTalk)
				)
			)
			(10 (proc0_18 Cheri 700 20 108))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance trampSign of Prop
	(properties
		x 120
		y 100
		description {Cedule Tramp}
		lookStr {Píše se na ní, že jste před Trampovým kasinem.}
		view 700
		loop 1
		signal $4000
		cycleSpeed 3
		detailLevel 1
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance slotSign of Prop
	(properties
		x 74
		y 38
		description {cedule hracích automatů}
		lookStr {Předpokládáš, že uvnitř musí být nějaká forma mechanizovaného hazardu.}
		view 700
		loop 4
		signal $4000
		cycleSpeed 5
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance leftLight of Prop
	(properties
		x 67
		y 123
		description {světlo}
		lookStr {Není neon parádní!!}
		view 700
		loop 2
		signal $4000
		cycleSpeed 2
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance rightLight of Prop
	(properties
		x 173
		y 124
		description světlo}
		lookStr {Není neon parádní!}
		view 700
		loop 3
		cel 1
		signal $4000
		cycleSpeed 4
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance leftNip of Prop
	(properties
		x 43
		y 41
		description {neonové bradavky}
		view 700
		loop 6
		signal $4000
		cycleSpeed 1
		detailLevel 3
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (Random 0 1)
					(proc0_14 700 21)
				else
					(proc0_14 700 22)
				)
			)
			(3
				(if (Random 0 1)
					(proc0_14 700 23)
				else
					(proc0_14 700 24)
				)
			)
			(5 (proc0_14 700 25))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance rightNip of Prop
	(properties
		x 220
		y 68
		description {neonové bradavky}
		view 700
		loop 5
		cel 1
		signal $4000
		cycleSpeed 1
		detailLevel 3
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(leftNip doVerb: theVerb param2 &rest)
	)
)

(instance centerNip of Prop
	(properties
		x 159
		y 27
		description {neonové bradavky}
		view 700
		loop 12
		cel 2
		signal $4000
		cycleSpeed 1
		detailLevel 3
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(leftNip doVerb: theVerb param2 &rest)
	)
)

(instance leftRoller of Prop
	(properties
		x 99
		y 51
		description {cedule hracích automatů}
		view 700
		loop 14
		signal $4000
		cycleSpeed 7
		detailLevel 3
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (Random 0 1)
					(proc0_14 700 26)
				else
					(proc0_14 700 27)
				)
			)
			(3 (proc0_14 700 28))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance middleRoller of Prop
	(properties
		x 110
		y 51
		description {cedule hracích automatů}
		view 700
		loop 14
		signal $4000
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(leftRoller doVerb: theVerb param2)
	)
)

(instance rightRoller of Prop
	(properties
		x 122
		y 51
		description {cedule hracích automatů}
		view 700
		loop 14
		cel 3
		signal $4000
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(leftRoller doVerb: theVerb param2)
	)
)

(instance leftNeon of Prop
	(properties
		x 52
		z -56
		description {neonový nápis}
		lookStr {Miluješ křiklavé věci!}
		view 700
		loop 9
		signal $4000
		cycleSpeed 5
		detailLevel 5
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance rightNeon of Prop
	(properties
		x 195
		z -70
		description {neonový nápis}
		lookStr {Miluješ křiklavé věci!}
		view 700
		loop 10
		signal $4000
		cycleSpeed 4
		detailLevel 5
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance centerNeon of Prop
	(properties
		x 125
		y 38
		description {neonový nápis}
		lookStr {Miluješ křiklavé věci!}
		view 700
		loop 11
		signal $4000
		cycleSpeed 3
		detailLevel 4
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance dollars of Prop
	(properties
		x 121
		y 115
		description {znak dolaru}
		lookStr {Tady je naznačeno, že by tu člověk mohl vyhrát nějaké peníze!}
		view 700
		loop 13
		signal $4000
		cycleSpeed 9
		detailLevel 3
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance burgerStand of Feature
	(properties
		x 280
		y 130
		nsTop 111
		nsLeft 241
		nsBottom 149
		nsRight 319
		description {stánek s hamburgery}
		sightAngle 40
		lookStr {To je vzrušující! Na Trampově promenádě je restaurace, kde se podává mrtvá kráva!}
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 0)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 700 29))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance boardwalk of Feature
	(properties
		x 280
		y 161
		nsTop 150
		nsLeft 241
		nsBottom 173
		nsRight 319
		description {na promenádě}
		sightAngle 40
		lookStr {Promenáda vede na východ a táhne se téměř kam až oko dohlédne.}
	)
)

(instance beach of Feature
	(properties
		x 183
		y 109
		nsTop 176
		nsLeft 234
		nsBottom 190
		nsRight 320
		description {pláž}
		sightAngle 40
		lookStr {Ten malý pruh písku vede k prudkému srázu a pak přímo do Atlantiku! Chceš si zaplavat?}
	)
)

(instance breasts1 of Feature
	(properties
		x 42
		y 55
		nsTop 33
		nsLeft 31
		nsBottom 42
		nsRight 53
		description {světla}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(leftNip doVerb: theVerb param2)
	)
)

(instance breasts2 of Feature
	(properties
		x 156
		y 20
		nsTop 11
		nsLeft 148
		nsBottom 29
		nsRight 165
		description {světla}
		sightAngle 40
	)
	
	(method (doVerb)
		(leftNip doVerb: &rest)
	)
)

(instance breasts3 of Feature
	(properties
		x 214
		y 74
		nsTop 60
		nsLeft 205
		nsBottom 72
		nsRight 224
		description {zadní část}
		sightAngle 40
	)
	
	(method (doVerb)
		(leftNip doVerb: &rest)
	)
)

(instance ass1 of Feature
	(properties
		x 33
		y 62
		nsTop 55
		nsLeft 26
		nsBottom 70
		nsRight 43
		description {zadní část}
		sightAngle 40
		lookStr {Těsné prdelky tě přivádějí k šílenství!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 700 30))
			(5 (proc0_14 700 31))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ass2 of Feature
	(properties
		x 120
		y 15
		nsLeft 108
		nsBottom 16
		nsRight 133
		sightAngle 40
	)
	
	(method (doVerb)
		(ass1 doVerb: &rest)
	)
)

(instance ass3 of Feature
	(properties
		x 213
		y 87
		nsTop 80
		nsLeft 204
		nsBottom 95
		nsRight 223
		description {zadní část}
		sightAngle 40
	)
	
	(method (doVerb)
		(ass1 doVerb: &rest)
	)
)

(instance girl1 of Feature
	(properties
		x 34
		y 54
		nsTop 20
		nsLeft 8
		nsBottom 88
		nsRight 61
		description {dívka na ceduli}
		sightAngle 40
		lookStr {Jistě, je jen z překližky, ale nejsou na ní skvělá světla?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 700 32))
			(5 (proc0_14 700 33))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance girl2 of Feature
	(properties
		x 138
		y 14
		nsLeft 92
		nsBottom 28
		nsRight 185
		description {dívka}
		sightAngle 40
		lookStr {Je v jedné z tvých oblíbených pozic... na ceduli!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 700 34))
			(5 (proc0_14 700 35))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance girl3 of Feature
	(properties
		x 206
		y 72
		nsTop 39
		nsLeft 180
		nsBottom 105
		nsRight 232
		description {dívka}
		sightAngle 40
		lookStr {A vy jste se tak báli, že jste za tuhle hru vyhodili peníze!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 700 36))
			(5 (proc0_14 700 37))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Cheri of Talker
	(properties
		nsTop 15
		nsLeft 12
		view 1702
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust (= bust girlBust))
		(= eyes (= eyes girlEyes))
		(= mouth (= mouth girlMouth))
		(super init: &rest)
	)
)

(instance girlEyes of Prop
	(properties
		nsTop 8
		nsLeft 8
		view 1702
		loop 2
		cycleSpeed 30
	)
)

(instance girlBust of Prop
	(properties
		view 1702
		loop 1
	)
)

(instance girlMouth of Prop
	(properties
		nsTop 33
		nsLeft 30
		view 1702
		cycleSpeed 8
	)
)

(instance Doorman of Talker
	(properties
		nsTop 15
		nsLeft 50
		view 1703
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust (= bust manBust))
		(= eyes (= eyes manEyes))
		(= mouth (= mouth manMouth))
		(super init: &rest)
	)
)

(instance manBust of Prop
	(properties
		view 1703
		loop 1
	)
)

(instance manEyes of Prop
	(properties
		nsTop 8
		nsLeft 8
		view 1703
		loop 2
		cycleSpeed 30
	)
)

(instance manMouth of Prop
	(properties
		nsTop 31
		nsLeft 11
		view 1703
		cycleSpeed 8
	)
)

(instance trampSignF of Feature
	(properties
		x 121
		y 152
		z 69
		nsTop 70
		nsLeft 88
		nsBottom 97
		nsRight 154
		description {značka Tramp}
		sightAngle 40
		lookStr {Píše se tu, že jste před Trampovým kasinem.}
	)
)

(instance leftLightF of Feature
	(properties
		x 68
		y 157
		z 58
		nsTop 82
		nsLeft 62
		nsBottom 117
		nsRight 75
		description {světlo}
		sightAngle 40
		lookStr {Není neon parádní!}
	)
)

(instance rightLightF of Feature
	(properties
		x 172
		y 158
		z 59
		nsTop 81
		nsLeft 162
		nsBottom 118
		nsRight 182
		description {světlo}
		sightAngle 40
		lookStr {Není neon parádní!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance slotSignF of Feature
	(properties
		x 62
		y 160
		z 103
		nsTop 37
		nsLeft 53
		nsBottom 78
		nsRight 71
		description {nápis na automatech}
		sightAngle 40
		lookStr {Předpokláš, že uvnitř musí být nějaká forma mechanizovaného hazardu.}
	)
)

(instance leftNeonF of Feature
	(properties
		x 28
		y 157
		z 143
		nsTop 1
		nsLeft 4
		nsBottom 28
		nsRight 53
		description {neonový nápis}
		sightAngle 40
		lookStr {Jak miluješ křiklavé věci!}
	)
)

(instance rightNeonF of Feature
	(properties
		x 206
		y 157
		z 137
		nsLeft 185
		nsBottom 41
		nsRight 228
		description {neonový nápis}
		sightAngle 40
		lookStr {Jak miluješ křiklavé věci!}
	)
)

(instance centerNeonF of Feature
	(properties
		x 124
		y 158
		z 126
		nsTop 25
		nsLeft 110
		nsBottom 40
		nsRight 139
		description neonový nápis}
		sightAngle 40
		lookStr {Jak miluješ křiklavé věci!}
	)
)

(instance dollarsF of Feature
	(properties
		x 124
		y 159
		z 50
		nsTop 102
		nsLeft 90
		nsBottom 116
		nsRight 158
		description {znak dolaru}
		sightAngle 40
		lookStr {Tady je naznačeno, že by tu člověk mohl vyhrát nějaké peníze!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		flags $0001
	)
)
