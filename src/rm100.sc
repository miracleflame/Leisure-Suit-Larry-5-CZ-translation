;;; Sierra Script 1.0 - (do not remove this comment)
(script# 100)
(include sci.sh)
(use Main)
(use LLRoom)
(use Class_255_0)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm100 0
)

(local
	local0
	local1
	[local2 50]
	[local52 12]
	local64
)
(procedure (localproc_0a42 &tmp [temp0 2] temp2 temp3)
	(= temp2 (StrAt @local2 local0))
	(Format @temp0 {%c} temp2)
	(= temp3
		(Display
			@temp0
			dsCOORD
			local1
			160
			dsCOLOR
			global128
			dsWIDTH
			7
			dsALIGN
			0
			dsFONT
			global173
			dsSAVEPIXELS
		)
	)
	(if (and (< 21 local0) (< local0 29))
		(= [local52 (- local0 22)] temp3)
	else
		(UnLoad 133 temp3)
	)
	(= local1 (+ local1 7))
	(if (== 32 temp2) (= local1 (- local1 2)))
)

(instance rm100 of LLRoom
	(properties
		picture 100
		style $000a
	)
	
	(method (init)
		(proc958_0 129 105)
		(proc958_0 128 105 106 107 108 109)
		(proc958_0 132 101 102 103 104 105)
		(gLongSong number: 100 setLoop: -1 flags: 1 play:)
		(StrCpy
			@local2
			{Vášnivá Patti Pracuje v Pittsbmalinko v utajení}
		)
		(super init:)
		(proc0_2)
		(gLl5KDHandler addToFront: self)
		(gLl5MDHandler addToFront: self)
		(proc0_13 120)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gLl5KDHandler delete: self)
		(gLl5MDHandler delete: self)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(pEvent type?)
				(!= (pEvent message?) KEY_ESCAPE)
				(!= (pEvent message?) KEY_ALT_a)
				(!= (pEvent message?) KEY_ALT_r)
				(!= (pEvent message?) KEY_ALT_t)
			)
			(if
				(proc255_0
					100
					0
					80
					{Pøeskoèit}
					82
					990
					11
					0
					106
					81
					{Opravdu? Ukaž mi to!}
					1
					81
					{Uups}
					0
				)
				(gIconBar
					curIcon: (gIconBar at: 5)
					handleEvent: (pEvent type: 4 message: 27 yourself:)
				)
			)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent &rest)
		)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local64 (Palette 6 24 31 -1) (Palette 6 240 254 -1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(larry init:)
				(patti init:)
				(blankPanel init:)
				(glue init:)
				(global2 drawPic: 105 10)
				(= seconds 3)
			)
			(2 (larry setCycle: End self))
			(3
				(broomUp play:)
				(larry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(broomUp play:)
				(larry setCel: 0 setCycle: End self)
			)
			(5
				(glue setPri: 0)
				(larry setLoop: 3 setCycle: End self)
			)
			(6 (= seconds 3))
			(7
				(brush init:)
				(larry setLoop: 4 setCel: 0 setCycle: End self)
			)
			(8
				(blankPanel dispose:)
				(larry view: 108 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(9
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(larry
					setLoop: 1
					setCel: 0
					x: (+ (larry x?) 20)
					setCycle: End self
				)
			)
			(11
				(larry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(12
				(= local64 1)
				(= seconds 5)
			)
			(13
				(patti setCycle: Walk setMotion: MoveTo 15 140 self)
			)
			(14
				(patti setMotion: MoveTo 335 140)
				(= local0 0)
				(= local1 3)
				(larry setScript: sLarryCartoon)
				(= cycles 1)
			)
			(15
				(localproc_0a42)
				(typewriter play:)
				(if (< (++ local0) 29)
					(= cycles (Random 3 5))
					(-- state)
				else
					(= cycles 10)
				)
			)
			(16
				(Display
					{}
					dsRESTOREPIXELS
					[local52 (- (-- local0) 22)]
				)
				(backSpace play:)
				(if (> local0 22)
					(= cycles 4)
					(-- state)
				else
					(= local1 153)
					(= local0 29)
					(= cycles 10)
				)
			)
			(17
				(localproc_0a42)
				(typewriter play:)
				(if (< (++ local0) (StrLen @local2))
					(-- state)
					(= cycles (Random 3 5))
				else
					(= cycles 10)
				)
			)
			(18 (= ticks 270))
			(19
				(global2 newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance sLarryCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(larry
					setLoop: 4
					setCel: 0
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				(larry
					view: 106
					setLoop: 4
					setCel: 0
					posn: 268 133
					setCycle: CT 3 1 self
					setMotion: MoveTo 263 133 self
				)
			)
			(2)
			(3
				(glue dispose:)
				(larry setCycle: CT 5 1 self)
			)
			(4
				(footInBucket play:)
				(larry setCycle: End self)
			)
			(5
				(larry
					setLoop: 0
					setCel: 0
					x: (- (larry x?) 5)
					setCycle: CT 4 1 self
				)
			)
			(6
				(glueStretch play:)
				(larry setCycle: End self)
			)
			(7 (larry setCycle: Beg self))
			(8
				(larry
					setLoop: 1
					setCel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(9
				(larry
					setLoop: 2
					setCel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(10
				(larry setLoop: 3 setCel: 0 setCycle: End self)
			)
			(11
				(larry
					view: 107
					setLoop: 0
					setCel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(12
				(glueStretch play:)
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13 (self dispose:))
		)
	)
)

(instance larry of Actor
	(properties
		x 230
		y 132
		view 105
		loop 1
		signal $4000
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance patti of Actor
	(properties
		x -16
		y 140
		view 109
		signal $4000
		cycleSpeed 10
		xStep 5
		moveSpeed 10
	)
)

(instance blankPanel of View
	(properties
		x 223
		y 108
		view 108
		loop 3
		signal $4001
	)
)

(instance glue of View
	(properties
		x 251
		y 132
		view 105
		signal $4001
	)
)

(instance brush of View
	(properties
		x 256
		y 132
		view 105
		cel 1
		signal $4001
	)
)

(instance footInBucket of Sound
	(properties
		number 101
	)
)

(instance typewriter of Sound
	(properties
		number 102
	)
)

(instance broomUp of Sound
	(properties
		number 103
	)
)

(instance glueStretch of Sound
	(properties
		number 104
	)
)

(instance backSpace of Sound
	(properties
		number 105
	)
)
